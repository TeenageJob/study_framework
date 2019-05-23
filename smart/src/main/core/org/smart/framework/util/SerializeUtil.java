package org.smart.framework.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.plugin.cache.CacheException;

/**
 * 序列化工具类
 */
public class SerializeUtil {
	/**
	 * 序列化
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos;
		ByteArrayOutputStream baos;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			return baos.toByteArray();
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	/**
	 * 反序列化
	 */
	public static Object unserialize(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bais;
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			return new String(bytes);
		}

	}

	public static String serialize(Session session) {
		ObjectOutputStream oos;
		ByteArrayOutputStream baos;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(session);
			return Base64.encodeToString(baos.toByteArray());
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}
	 public static Session deserialize(String sessionStr) {
	        try {
	            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(sessionStr));
	            ObjectInputStream ois = new ObjectInputStream(bis);
	            return (Session)ois.readObject();
	        } catch (Exception e) {
	            throw new RuntimeException("deserialize session error", e);
	        }
	    }
}