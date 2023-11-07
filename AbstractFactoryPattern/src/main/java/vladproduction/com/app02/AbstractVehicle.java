package vladproduction.com.app02;

import vladproduction.com.app02.components.ClimateSystem;
import vladproduction.com.app02.components.GPSSystem;
import vladproduction.com.app02.components.Wheel;

import java.util.Objects;

public abstract class AbstractVehicle implements Vehicle{

    protected  VehicleAbstractFactory.VehicleType vehicleType;
    protected  VehicleAbstractFactory.ManufactureType manufactureType;

    protected Wheel wheel;
    protected  GPSSystem gpsSystem;
    protected  ClimateSystem climateSystem;


    public AbstractVehicle(VehicleAbstractFactory.VehicleType vehicleType,
                           VehicleAbstractFactory.ManufactureType manufactureType,
                           Wheel wheel, GPSSystem gpsSystem, ClimateSystem climateSystem) {
        this.vehicleType = vehicleType;
        this.manufactureType = manufactureType;
        this.wheel = wheel;
        this.gpsSystem = gpsSystem;
        this.climateSystem = climateSystem;
    }



    public Wheel getWheel() {
        return wheel;
    }



    public void setWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    public void setGpsSystem(GPSSystem gpsSystem) {
        this.gpsSystem = gpsSystem;
    }

    public GPSSystem getGpsSystem() {
        return gpsSystem;
    }

    public void setClimateSystem(ClimateSystem climateSystem) {
        this.climateSystem = climateSystem;
    }

    public VehicleAbstractFactory.VehicleType getVehicleType() {
        return vehicleType;
    }

    public VehicleAbstractFactory.ManufactureType getManufactureType() {
        return manufactureType;
    }

    public ClimateSystem getClimateSystem() {
        return climateSystem;
    }

    @Override
    public void createVehicle() {
        StringBuilder builder = new StringBuilder();

        builder.append(manufactureType);
        builder.append("\nmodel = ").append(vehicleType);
        if(wheel != null){

            String brand = wheel.getBrand();
            builder.append("\nwheel brand = ").append(brand);
            int wheelSize = wheel.getSize();
            builder.append("\nwheel size = ").append(wheelSize);
        }
        if(gpsSystem != null){

            String gpsModel = gpsSystem.getModel();
            builder.append("\ngps Model = ").append(gpsModel);
        }
        if(climateSystem != null) {

            String conditioning = climateSystem.name();
            builder.append("\nconditioning = ").append(conditioning);
        }
        System.out.println(builder);

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AbstractVehicle that = (AbstractVehicle) object;
        return  vehicleType == that.vehicleType &&
                manufactureType == that.manufactureType &&
                Objects.equals(wheel, that.wheel) &&
                Objects.equals(gpsSystem, that.gpsSystem) &&
                climateSystem == that.climateSystem;
    }

    @Override
    public int hashCode() {

        return Objects.hash(vehicleType, manufactureType, wheel, gpsSystem, climateSystem);
    }
}
