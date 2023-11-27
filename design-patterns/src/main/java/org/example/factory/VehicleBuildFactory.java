package org.example.factory;

public class VehicleBuildFactory {
    private Vehicle mini;
    private Vehicle suv;
    private Vehicle jeep;
    public VehicleBuildFactory(VehicleFactory vehicleFactory) {
        this.jeep = vehicleFactory.buildJeep();
        this.mini = vehicleFactory.buildMini();
        this.suv = vehicleFactory.buildSUV();
    }
    // мы предоставляем без изменений функционала передаем пользователю эту BuildFactory
    // и она не привязана к пстроению Jeep, Mini, SUV
    // то ли то bmw, то ли range rover - они по разному строят свои машинки - у них свои
    // собственные производсвенные процессы
    // Юзеру не важно знать какие происходят процессы построения
    // Для клиента изменений не будет - он получит авто, но под капотом все будет по другому
    public Vehicle buildMini(){
        mini.createVehicle();
        return mini;
    }

    public Vehicle buildSUV(){
        suv.createVehicle();
        return suv;
    }

    public Vehicle buildJepp(){
        jeep.createVehicle();
        return jeep;
    }
}
