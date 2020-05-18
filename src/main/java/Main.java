import com.google.gson.Gson;
import models.*;
import view.MainPage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    Filter filter1 = new Filter("brand");
    Filter filter2 = new Filter("existing");
    Filter filter3 = new Filter("price");
    public static void main(String[] args)
    {
        new MainPage(null).execute();
    }

}
