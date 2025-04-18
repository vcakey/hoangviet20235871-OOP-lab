package ooplab2;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    
    private static int nbDigitalVideoDiscs = 0;
    private int id;

    // Constructor đầy đủ tham số
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;
    }

    // Setter để kiểm tra tham chiếu
    public void setTitle(String title) {
        this.title = title;
    }
}
