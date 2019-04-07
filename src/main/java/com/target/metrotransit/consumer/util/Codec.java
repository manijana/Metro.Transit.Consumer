package com.target.metrotransit.consumer.util;

import com.google.gson.Gson;

public class Codec<T> {
	
	// Converts Object to JSON String
	public String toJson(T obj) {
        return new Gson().toJson(obj);
    }
    
	// Converts JSON String to Object
    public Object fromJson(String json, T obj){
        return new Gson().fromJson(json, obj.getClass());
    }
}
