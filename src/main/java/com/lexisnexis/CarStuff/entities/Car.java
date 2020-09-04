package com.lexisnexis.CarStuff.entities;

import java.util.Date;

public class Car {

    private String id;
    private Integer number;
    private String make;
    private String fuelType;
    private String aspiration;
    private String numOfDoors;
    private String bodyStyle;
    private String driveWheels;
    private String engineLocation;
    private Double wheelBase;
    private Double length;
    private Double width;
    private Double height;
    private Double curbWeight;
    private String engineType;
    private String numOfCylinders;
    private Double engineSize;
    private String fuelSystem;
    private Double compressionRatio;
    private String horsepower;
    private String peakRpm;
    private Double cityMpg;
    private Double highwayMpg;
    private String price;
    private Date createdDate;
    private Date lastUpdatedDate;

    public Car() {
    }

    public Car(Integer number, String make, String fuelType, String aspiration, String numOfDoors, String bodyStyle, String driveWheels, String engineLocation, Double wheelBase, Double length, Double width, Double height, Double curbWeight, String engineType, String numOfCylinders, Double engineSize, String fuelSystem, Double compressionRatio, String horsepower, String peakRpm, Double cityMpg, Double highwayMpg, String price) {
        this.number = number;
        this.make = make;
        this.fuelType = fuelType;
        this.aspiration = aspiration;
        this.numOfDoors = numOfDoors;
        this.bodyStyle = bodyStyle;
        this.driveWheels = driveWheels;
        this.engineLocation = engineLocation;
        this.wheelBase = wheelBase;
        this.length = length;
        this.width = width;
        this.height = height;
        this.curbWeight = curbWeight;
        this.engineType = engineType;
        this.numOfCylinders = numOfCylinders;
        this.engineSize = engineSize;
        this.fuelSystem = fuelSystem;
        this.compressionRatio = compressionRatio;
        this.horsepower = horsepower;
        this.peakRpm = peakRpm;
        this.cityMpg = cityMpg;
        this.highwayMpg = highwayMpg;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getAspiration() {
        return aspiration;
    }

    public void setAspiration(String aspiration) {
        this.aspiration = aspiration;
    }

    public String getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(String numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getDriveWheels() {
        return driveWheels;
    }

    public void setDriveWheels(String driveWheels) {
        this.driveWheels = driveWheels;
    }

    public String getEngineLocation() {
        return engineLocation;
    }

    public void setEngineLocation(String engineLocation) {
        this.engineLocation = engineLocation;
    }

    public Double getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(Double wheelBase) {
        this.wheelBase = wheelBase;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getCurbWeight() {
        return curbWeight;
    }

    public void setCurbWeight(Double curbWeight) {
        this.curbWeight = curbWeight;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getNumOfCylinders() {
        return numOfCylinders;
    }

    public void setNumOfCylinders(String numOfCylinders) {
        this.numOfCylinders = numOfCylinders;
    }

    public Double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Double engineSize) {
        this.engineSize = engineSize;
    }

    public String getFuelSystem() {
        return fuelSystem;
    }

    public void setFuelSystem(String fuelSystem) {
        this.fuelSystem = fuelSystem;
    }

    public Double getCompressionRatio() {
        return compressionRatio;
    }

    public void setCompressionRatio(Double compressionRatio) {
        this.compressionRatio = compressionRatio;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(String horsepower) {
        this.horsepower = horsepower;
    }

    public String getPeakRpm() {
        return peakRpm;
    }

    public void setPeakRpm(String peakRpm) {
        this.peakRpm = peakRpm;
    }

    public Double getCityMpg() {
        return cityMpg;
    }

    public void setCityMpg(Double cityMpg) {
        this.cityMpg = cityMpg;
    }

    public Double getHighwayMpg() {
        return highwayMpg;
    }

    public void setHighwayMpg(Double highwayMpg) {
        this.highwayMpg = highwayMpg;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        if(createdDate!=null){
            this.createdDate = createdDate;
        }
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", make='" + make + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", aspiration='" + aspiration + '\'' +
                ", numOfDoors='" + numOfDoors + '\'' +
                ", bodyStyle='" + bodyStyle + '\'' +
                ", driveWheels='" + driveWheels + '\'' +
                ", engineLocation='" + engineLocation + '\'' +
                ", wheelBase='" + wheelBase + '\'' +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", curbWeight='" + curbWeight + '\'' +
                ", engineType='" + engineType + '\'' +
                ", numOfCylinders='" + numOfCylinders + '\'' +
                ", engineSize='" + engineSize + '\'' +
                ", fuelSystem='" + fuelSystem + '\'' +
                ", compressionRatio='" + compressionRatio + '\'' +
                ", horsepower='" + horsepower + '\'' +
                ", peakRpm='" + peakRpm + '\'' +
                ", cityMpg='" + cityMpg + '\'' +
                ", highwayMpg='" + highwayMpg + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Car)){
            return false;
        }
        Car c =(Car) obj;
        return number.equals(c.number);
    }
}