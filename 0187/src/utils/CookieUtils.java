package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;

public class CookieUtils {

	public static Cookie findCookie(Cookie[] cookies, String name) throws UnsupportedEncodingException {
		
		//��������û��cookie ����null
			if(cookies == null){
				// �����û��Я���κε�Cookie
				return null;
			}else{
				for (Cookie cookie : cookies) {
					// �ж������е�ÿ��cookie����������������Ƿ�һ��
					if(name.equals(cookie.getName())){
						// ֱ�ӷ��أ�
						cookie.setValue(URLDecoder.decode(cookie.getValue(), "utf-8"));
						return cookie;
					}
				}
				// ���������Cookie�����ˣ�����û��ָ�����Ƶ��Ǹ�Cookie
				return null;
			}
		}

}
