package comwow2778.naver.blog.app4;

/**
 * Created by seon on 2017-03-30.
 */
public class Table {
    String name;
    int time;
    int spacount;
    int pizzacount;
    int membership;
    int total;

    public Table(String name, int time, int spacount, int pizzacount, int membership,int total){
        this.name =name;
        this.time =time;
        this.spacount =spacount;
        this.pizzacount =pizzacount;
        this.membership = membership;
        this.total=total;
    }
}
