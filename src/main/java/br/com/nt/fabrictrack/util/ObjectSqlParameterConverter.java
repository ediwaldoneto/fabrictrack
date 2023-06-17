/**
 * 
 */
package br.com.nt.fabrictrack.util;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 * @author Neto
 *
 */
public class ObjectSqlParameterConverter {

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");
    
    private ObjectSqlParameterConverter() {
    }

    public static MapSqlParameterSource convert(Object object) {
	MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	addValuesProperties(parameterSource, object);
	return parameterSource;
    }

    private static void addValuesProperties(MapSqlParameterSource parameterSource, Object object) {
	Class<?> clazz = object.getClass();
	if (clazz.getSuperclass() != null) {
	    addValuesProperties(parameterSource, object, clazz.getSuperclass());
	}
	addValuesProperties(parameterSource, object, clazz);
    }

    private static void addValuesProperties(MapSqlParameterSource parameterSource, Object object,
	    Class<?> clazz) {
	Field[] fields = clazz.getDeclaredFields();
	for (Field field : fields) {
	    field.setAccessible(true);
	    String nomePropriedade = field.getName();
	    Object valorPropriedade;
	    try {
		valorPropriedade = field.get(object);
		parameterSource.addValue(nomePropriedade, valorPropriedade);
	    } catch (IllegalAccessException e) {
		log.error(e.getMessage());
	    }
	}
    }
}
