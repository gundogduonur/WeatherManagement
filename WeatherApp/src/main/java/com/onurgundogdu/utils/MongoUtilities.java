package com.onurgundogdu.utils;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import com.onurgundogdu.common.georaphy.City;
import com.onurgundogdu.common.georaphy.Country;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public enum MongoUtilities { // singleton pattern'ýnýn enum olarak implemente edilmiþ þekli
    INSTANCE;

    private MongoClient              client;
    private MongoDatabase            database;
    private PojoCodecProvider        codecProvider;
    private CodecRegistry            pojoCodecRegistry;
    private MongoCollection<Country> countries;


    private MongoUtilities() {
        LogUtil.getInstance().logInfo(MongoUtilities.class.getSimpleName() + " --> " + "Calling constrator");

        initDatabase();
    }

    private void initDatabase() {
        LogUtil.getInstance().logInfo(MongoUtilities.class.getSimpleName() + " --> " + "init database and read data");

        this.client            = new MongoClient("localhost", 27017);
        this.database          = this.client.getDatabase("mongoDB");
        this.codecProvider     = PojoCodecProvider.builder().automatic(true).build();
        this.pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(this.codecProvider));
        countries              = database.withCodecRegistry(pojoCodecRegistry).getCollection("countries",Country.class);
    }

    private MongoCollection<Country> getCountryCollection(){
        LogUtil.getInstance().logInfo(MongoUtilities.class.getSimpleName() + " --> " + "Retrieving country collection");

        if (this.database == null)
            this.initDatabase();
        return this.countries;
    }

    public List<String> getCountries() {
        List<String> retVal = new ArrayList<>();

        Iterable<Country> iter = this.getCountryCollection().find();
        iter.forEach(country -> retVal.add(country.getName()));
        return retVal;
    }

    public ArrayList<City> getCities(String country) {
        Bson filter = eq("country_name", country);
        return this.getCountryCollection().find(filter).first().getCities();
    }
}