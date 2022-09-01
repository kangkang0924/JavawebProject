package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

public class CookieUtils {

	public static Cookie findCookie(Cookie[] cookies, String name) throws UnsupportedEncodingException {
		
		//如果浏览器没有cookie 返回null
			if(cookies == null){
				// 浏览器没有携带任何的Cookie
				return null;
			}else{
				for (Cookie cookie : cookies) {
					// 判断数组中的每个cookie的名称与给定名称是否一致
					if(name.equals(cookie.getName())){
						// 直接返回：
						cookie.setValue(URLDecoder.decode(cookie.getValue(), "utf-8"));
						return cookie;
					}
				}
				// 浏览器带有Cookie过来了，但是没有指定名称的那个Cookie
				return null;
			}
		}

}
