package com.masai.module;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;

public class StringSequenceGenerator extends SequenceStyleGenerator{
	
	

	public static final String VALUE_PREFIX_PARAMETER="valueP";
	
	public static final String VALUE_PREFIX_DEFAULT="";
	
	private String valueP;
	
	public static final String NUMBER_FORMAT_PARAMETER= "numberFor";
	
	public static final String NUMBER_FORMAT_DEFAULT= "%d";
	
	private String numberFor;
	
	@Override
	public void configure(org.hibernate.type.Type type, Properties params, ServiceRegistry serviceRegistry)
			throws MappingException {
		super.configure(LongType.INSTANCE, params, serviceRegistry);
		valueP= ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,params, VALUE_PREFIX_DEFAULT);
		numberFor= ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,params,NUMBER_FORMAT_DEFAULT);
		
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		return valueP + String.format(numberFor, super.generate(session, object));
	}
		
	
}
