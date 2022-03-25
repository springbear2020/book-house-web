package com.bear.bookhouse.util;

import com.maxmind.db.CHMCache;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.URL;
import java.util.Map;
import java.util.Objects;

/**
 * @author Spring-_-Bear
 * @datetime 2022/3/16 19:42
 */
public class WebUtil {
    private static DatabaseReader cityReader;

    // 读取配置文件，加载 GeoLite2-City.mmdb 数据库资源文件
    static {
        URL cityFileUrl = WebUtil.class.getClassLoader().getResource("GeoLite2-City.mmdb");
        File cityFile = new File(Objects.requireNonNull(cityFileUrl).getPath());
        try {
            cityReader = (new DatabaseReader.Builder(cityFile).withCache(new CHMCache())).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析 ip 地址，从 GeoLite2-City.mmdb 数据库中获取对应的国家、省份、城市等信息
     *
     * @param ip ip
     * @return ip 所对应的国家、省份、城市信息
     */
    public static String parseIp(String ip) {
        // 根据 ip 从 GeoLite2-City.mmdb 数据库中获得响应
        CityResponse cityResponse;
        try {
            cityResponse = cityReader.city(InetAddress.getByName(ip));
        } catch (IOException | GeoIp2Exception e) {
            return "";
        }
        // 从响应中获取国家、省份、城市对象并获取响应信息
        return cityResponse.getCountry().getNames().get("zh-CN") + " " + cityResponse.getMostSpecificSubdivision().getNames().get("zh-CN") + " " + cityResponse.getCity().getNames().get("zh-CN");
    }

    /**
     * 从请求头中获取请求 ip 地址
     *
     * @param request 请求头
     * @return ip
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        String unknown = "unknown";
        // 依次解析，找到正确的ip
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 将客户端表单的请求参数转换为对应 JavaBean
     *
     * @param bean  目标 JavaBean 对象
     * @param value 客户端请求参数
     * @return java bean or null
     */
    public static <T> T copyParamsToBean(T bean, Map<String, String[]> value) {
        try {
            org.apache.commons.beanutils.BeanUtils.populate(bean, value);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
