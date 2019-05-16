package huji.hostia;

class User {
    private String name;
    private Long ID;


    User(String name, Long id) {
        this.name = name;
        ID = id;
    }

    String getName(){
        return name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}


//todo: public Task<Location> getLastLocation ()