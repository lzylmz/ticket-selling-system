package UI;

import classes.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TitledPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Seats extends Application {

    //initialize different components and variables used in application
    Label title;
    Label one,two, space0, space,space1,space2,space3, three,four, info, infoMoney;

    Label flightID,time,tickets,total,mySeats,flight_ans,time_ans,tickets_ans,total_ans,seats_ans,available,sold,selected;
    Label labelDataShow, labelAirCraftShow, labelLuggageShow, labelCapacityShow;
    Label labelFlightId, labelAirCraft, labelLuggage, labelCapacity;
    Label labelCompanyName, labelTargetCity, labelCurrentCity, labelFlightDate, labelFlightTime, labelArrivalTime;
    Button book,b_available,b_sold,b_selected;

    Button r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9,r1c10;
    Button r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9,r2c10;
    Button r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9,r3c10;
    Button r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9,r4c10;

    String grey = "-fx-background-color:#B2BEB5";
    String green = "-fx-background-color:#32CD32";

    String[] btn = {"r1c1","r1c2","r1c3","r1c4","r1c5","r1c6","r1c7","r1c8","r1c9","r1c10","r2c1","r2c2","r2c3","r2c4","r2c5","r2c6","r2c7","r2c8","r2c9","r2c10","r3c1","r3c2","r3c3","r3c4","r3c5","r3c6","r3c7","r3c8","r3c9", "r4c10", "r4c1","r4c2","r4c3","r4c4","r4c5","r4c6","r4c7","r4c8","r4c9","r4c10"};
    String[] btn_clr = {grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey,grey};
    Button[] all_btn = {r1c1,r1c2,r1c3,r1c4,r1c5,r1c6,r1c7,r1c8,r1c9,r1c10,r2c1,r2c2,r2c3,r2c4,r2c5,r2c6,r2c7,r2c8,r2c9,r2c10,r3c1,r3c2,r3c3,r3c4,r3c5,r3c6,r3c7,r3c8,r3c9,r3c10,r4c1,r4c2,r4c3,r4c4,r4c5,r4c6,r4c7,r4c8,r4c9,r4c10,};
    Button[] selected_btn = new Button[40];

    String seats_val = "";
    int ticket = 0;
    int amount = 0;
    int count = 0;
    int flightNumber = 0;

    private ArrayList<Flight> flight ;
    private ArrayList<Flight> flights ;
    private ArrayList<ArrayList> control;
    private int controlNum;


    User u1=Login.u1;
    ArrayList<Ticket>t;

    private ArrayList<Seat> seatArr ;
    private ArrayList<Flight> showFlight ;
    String clr;

    /**
     * This method used to appear gui different colors in buttons
     * @param b is selected button
     * @param indx is index of button
     */
    public void setDisplay(Button b, int indx, Flight flight){
        //get current color of button
        clr = btn_clr[indx];
        //if button is grey colored, then goes to this statement
        //this statement used to order a seat
        if(clr==grey){
            b.setStyle(green);
            btn_clr[indx] = green;
            ticket++;
            if(indx<40){
                amount+=flight.getPrice();
                total_ans.setText(": $ "+amount);
            }

            tickets_ans.setText(": "+ticket);
            selected_btn[indx] = b;
            seats_val = ": ";
            for(int i=0;i<40;i++){
                if(selected_btn[i]!=null){
                    seats_val+=(btn[i]+" ");
                }
            }
            seats_ans.setText(seats_val);
        }
        //if button color is green, go to this statement
        //this statement used to remove order
        else if(clr==green){
            b.setStyle(grey);
            btn_clr[indx] = grey;
            ticket--;
            if(indx<40){
                amount-=flight.getPrice();
                total_ans.setText(": $ "+amount);

            }
            tickets_ans.setText(": "+ticket);
            selected_btn[indx] = null;
            seats_val = ": ";
            for(int i=0;i<40;i++){
                if(selected_btn[i]!=null){
                    seats_val+=(btn[i]+" ");
                }
            }
            seats_ans.setText(seats_val);
        }

    }


    @Override
    public void start(Stage stage) throws Exception {

         Stage stageSeat = new Stage();
         flight = new ArrayList<>();
         flights =new ArrayList<>();

          t=new ArrayList<>();
         u1.setMYticket(t);
         seatArr =new ArrayList<>();
         showFlight =new ArrayList<>();

         ArrayList<Integer> controlAr = new ArrayList<>();
         ArrayList<Integer> controlArr = new ArrayList<>();
         ArrayList<Integer> controlArrr = new ArrayList<>();
         control = new ArrayList<>();
         control.add(controlAr);
         control.add(controlArr);
         control.add(controlArrr);
         controlNum=0;

        Flight flight1 = new Flight("FNM 1","Ankara", "Corum", "Pegasus", "12.03.2023", "12:11 pm" , "Boing 760","03:01 am",  20, 1.30, 15.0 ,225.0);
        flights.add(flight1);

        Flight flight2 = new Flight("FNM 2","corum", "Ankara", "Turkish Airline", "12.05.2023", "11:00 am" , "Boing 760","12:12 pm",  20, 1.30, 15.0 ,225.0);
        flights.add(flight2);

        Flight flight3 = new Flight("FNM 3","danimarka", "Ankara", "xmnf", "02.03.2022", "10:00 pm" , "Boing 760","12:38 pm",  20, 1.30, 15.0 ,225.0);
        flights.add(flight3);
        flight.add(flight1);

        Pane mainPane = new Pane();  // first ticket interfaces
        Pane subPane1 = new Pane();  // for ticket information
        Button buyButton = new Button("Buy Ticket");
        Button nextButton =new Button("Next Fly");

        // design flight info part
        space1 = new Label("Flaying Start");
        space1.setFont(new Font("Impact",9));

        space2 = new Label("Flaying Complete");
        space2.setFont(new Font("Impact",9));

        space3 = new Label(" ");

        Separator separat = new Separator();
        separat.setOrientation(Orientation.HORIZONTAL);
        separat.setMinSize(5,5);
        separat.setMaxWidth(80);
        separat.setStyle("##0000FF");

        Separator separat1 = new Separator();
        separat.setOrientation(Orientation.HORIZONTAL);
        separat.setMinSize(5,5);
        separat.setMaxWidth(80);
        separat.setStyle("##0000FF");

        labelCompanyName = new Label();
        labelCompanyName.setFont(new Font("Helvetica",15));
        labelCompanyName.setTextFill(Color.rgb(0,165,0));
        labelCompanyName.setPrefSize(200,25);

        labelFlightId = new Label();
        labelFlightId.setFont(new Font("Verdana",10));
        labelFlightId.setPrefSize(200,25);

        labelTargetCity = new Label();
        labelTargetCity.setFont(new Font("Verdana",12));
        labelTargetCity.setPrefSize(200,25);

        labelFlightTime = new Label();
        labelFlightTime.setFont(new Font("Verdana",14));
        labelFlightTime.setPrefSize(200,25);

        labelArrivalTime = new Label();
        labelArrivalTime.setFont(new Font("Verdana",12));
        labelArrivalTime.setPrefSize(200,25);

        labelCurrentCity = new Label();
        labelCurrentCity.setFont(new Font("Verdana",12));
        labelCurrentCity.setPrefSize(200,25);

        labelCompanyName.setMinWidth(100);
        labelFlightId.setMinWidth(100);
        VBox vx1 = new VBox();
        vx1.getChildren().addAll(labelCompanyName,labelFlightId);
        vx1.setMinSize(80,0);
        vx1.setPrefWidth(0);

        labelFlightTime.setMinWidth(100);
        labelCurrentCity.setMinWidth(100);
        VBox vx2 = new VBox();
        vx2.getChildren().addAll(labelFlightTime, separat1, space1, labelCurrentCity);
        vx2.setMinSize(100,0);
        vx1.setPrefWidth(0);

        labelArrivalTime.setMinWidth(100);
        labelTargetCity.setMinWidth(100);
        VBox vx4 = new VBox();
        vx4.getChildren().addAll(labelArrivalTime, space2, separat,  labelTargetCity);
        vx4.setMinSize(100,0);
        vx4.setPrefWidth(0);

        VBox vx5 = new VBox();
        vx5.getChildren().addAll( nextButton ,space3, buyButton);
        vx5.setMinSize(100,0);

        Separator sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);
        sep.setMinSize(20,0);

        Separator sep1 = new Separator();
        sep1.setOrientation(Orientation.VERTICAL);
        sep1.setMinSize(20,0);

        HBox bAll = new HBox();
        bAll.getChildren().addAll(vx1,sep,vx2,vx4,sep1, vx5);
        bAll.setPadding(new Insets(5,5,5,5));
        bAll.setSpacing(10);

        //initialize label text
        labelCompanyName.setText(flight.get(0).getCompanyName());
        labelTargetCity.setText(flight.get(0).getTargetCity());
        labelCurrentCity.setText(flight.get(0).getCurrentCity());
        labelFlightTime.setText(flight.get(0).getFlightTime());
        labelArrivalTime.setText(flight.get(0).getArrivalTime());
        labelFlightId.setText(flight.get(0).getId());

        // design titledpane so more info part
        TitledPane titPane = new TitledPane("More Info", subPane1);
        titPane.setLayoutY(90);

        labelFlightDate = new Label();
        labelFlightDate.setFont(new Font("Verdana",12));
        labelFlightDate.setPrefSize(200,25);

        labelAirCraft = new Label();
        labelAirCraft.setFont(new Font("Verdana",12));
        labelAirCraft.setPrefSize(200,25);

        labelLuggage =new Label();
        labelLuggage.setFont(new Font("Verdana",12));
        labelLuggage.setPrefSize(200,25);

        labelCapacity = new Label();
        labelCapacity.setFont(new Font("Verdana",12));
        labelCapacity.setPrefSize(200,25);

        labelDataShow = new Label("Flight Data :");
        labelDataShow.setFont(new Font("Verdana",13));
        labelDataShow.setTextFill(Color.rgb(255,165,0));
        labelDataShow.setPrefSize(70,25);

        labelAirCraftShow = new Label("Air Craft :");
        labelAirCraftShow.setFont(new Font("Verdana",13));
        labelAirCraftShow.setTextFill(Color.rgb(255,165,0));
        labelAirCraftShow.setPrefSize(70,25);

        labelLuggageShow = new Label("Luggage :");
        labelLuggageShow.setFont(new Font("Verdana",13));
        labelLuggageShow.setTextFill(Color.rgb(255,165,0));
        labelLuggageShow.setPrefSize(70,25);

        labelCapacityShow = new Label("Capacity :");
        labelCapacityShow.setFont(new Font("Verdana",13));
        labelCapacityShow.setTextFill(Color.rgb(255,165,0));
        labelCapacityShow.setPrefSize(70,25);

        labelAirCraft.setText(flight.get(0).getAirCraft());
        labelLuggage.setText(String.valueOf(flight.get(0).getLuggageWeight()) + " kg");
        labelCapacity.setText(String.valueOf(flight.get(0).getCapacity()));
        labelFlightDate.setText(flight.get(0).getFlightDate());

        labelDataShow.setMinWidth(100);
        labelCapacityShow.setMinWidth(100);
        VBox v1 = new VBox();
        v1.getChildren().addAll(labelDataShow,labelCapacityShow);
        v1.setMinSize(100,0);

        labelFlightDate.setMinWidth(90);
        labelCapacity.setMinWidth(90);
        VBox v2 = new VBox();
        v2.getChildren().addAll(labelFlightDate,labelCapacity);
        v2.setMinSize(90,0);

        HBox box1 = new HBox();
        box1.getChildren().addAll(v1,v2);
        box1.setPadding(new Insets(5,5,5,5));
        box1.setSpacing(10);
        box1.setMaxWidth(180);

        labelLuggageShow.setMinWidth(95);
        labelAirCraftShow.setMinWidth(95);
        VBox v3 = new VBox();
        v3.getChildren().addAll(labelLuggageShow,labelAirCraftShow);
        v3.setMinSize(95,0);

        VBox v4 = new VBox();
        v4.getChildren().addAll(labelLuggage,labelAirCraft);
        v4.setMinSize(80,0);

        HBox box2 = new HBox();
        box2.getChildren().addAll(v3,v4);
        box2.setPadding(new Insets(5,5,5,5));
        box2.setSpacing(5);
        box2.setMaxWidth(150);

        HBox boxAll = new HBox();
        boxAll.getChildren().addAll(box1,box2);
        boxAll.setPadding(new Insets(5,5,5,5));
        boxAll.setSpacing(10);
        boxAll.setMaxWidth(150);


        // add elements in mainpane
        mainPane.getChildren().add(titPane);
        mainPane.getChildren().add(bAll);
        subPane1.getChildren().add(boxAll);

        Scene scene = new Scene(mainPane, 800, 300);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        // flight information are changed when you click next button
        EventHandler<ActionEvent> e = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                flightNumber++;
                if (flightNumber < flights.size())
                {
                    flight.set(0, flights.get(flightNumber));
                }// if we dont have more flight, we return first flight
                else {
                    flightNumber=0;
                    flight.set(0, flights.get(flightNumber));
                }

                 labelArrivalTime.setText(flight.get(0).getArrivalTime());
                 labelCompanyName.setText(flight.get(0).getCompanyName());
                 labelTargetCity.setText(flight.get(0).getTargetCity());
                 labelCurrentCity.setText(flight.get(0).getCurrentCity());
                 labelFlightDate.setText(flight.get(0).getFlightDate());
                 labelFlightTime.setText(flight.get(0).getFlightTime());
                 labelFlightId.setText(flight.get(0).getId());
                 labelAirCraft.setText(flight.get(0).getAirCraft());
                 labelLuggage.setText(String.valueOf(flight.get(0).getLuggageWeight()));
                 labelCapacity.setText(String.valueOf(flight.get(0).getCapacity()));

                 controlNum++;

            }
        };
        nextButton.setOnAction(e);


        showFlight.add(new Flight());

        EventHandler event = new EventHandler() { // oturma duzenini gosteren kisim
            @Override
            public void handle(Event event) {

            showFlight.set(0,  flight.get(0));  // showflight ile farkli flihtlar atandigi zaman onlar icin yeni event olusturmayacagiz.

                //design title
                title = new Label("Seats Argement");
                title.setPrefSize(500,80);
                title.setAlignment(Pos.CENTER);
                title.setFont(new Font("Lucida Sans Unicode",25));

                int[] label_btn = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};

                //design buttons in initially
                for(int i = 0; i<40; i++){
                    all_btn[i] = new Button(label_btn[i]+"");
                    all_btn[i].setPrefSize(30,35);
                    all_btn[i].setStyle(grey);
                    all_btn[i].setTextFill(Color.rgb(255,255,255));
                }

                one = new Label("1");
                one.setPrefSize(15,35);

                two = new Label("2");
                two.setPrefSize(15,35);

                three = new Label("3");
                three.setPrefSize(15,35);

                four = new Label("4");
                four.setPrefSize(15,35);

                info = new Label(" ");
                info.setFont(new Font("Helvetica" , 17));

                infoMoney = new Label(String.valueOf("your money amount:   " + u1.getWallet().getMoney()));

                infoMoney.setFont(new Font("Helvetica" , 13));

                HBox hb1 = new HBox();
                HBox hb2 = new HBox();
                HBox hb3 = new HBox();
                HBox hb4 = new HBox();
                HBox hb5 = new HBox();
                HBox hb6 = new HBox();
                HBox hb7 = new HBox();
                HBox hb8 = new HBox();

                space = new Label(" ");
                space.setPrefSize(10,15);

                space0 = new Label(" ");
                space0.setPrefSize(10,15);

                //grouping rows
                hb1.getChildren().addAll(one,all_btn[0],all_btn[1],all_btn[2],all_btn[3],all_btn[4],all_btn[5],all_btn[6],all_btn[7],all_btn[8],all_btn[9]);
                hb1.setSpacing(5);
                hb1.setPadding(new Insets(5,5,5,20));

                hb2.getChildren().addAll(two,all_btn[10],all_btn[11],all_btn[12],all_btn[13],all_btn[14],all_btn[15],all_btn[16],all_btn[17],all_btn[18],all_btn[19]);
                hb2.setSpacing(5);
                hb2.setPadding(new Insets(5,5,5,20));

                hb3.getChildren().add(space0);
                hb3.setSpacing(5);
                hb3.setPadding(new Insets(5,45,5,20));

                hb4.getChildren().addAll(three,all_btn[20],all_btn[21],all_btn[22],all_btn[23],all_btn[24],all_btn[25],all_btn[26],all_btn[27],all_btn[28],all_btn[29]);
                hb4.setSpacing(5);
                hb4.setPadding(new Insets(5,45,5,20));

                hb5.getChildren().addAll(four,all_btn[30],all_btn[31],all_btn[32],all_btn[33],all_btn[34],all_btn[35],all_btn[36],all_btn[37],all_btn[38],all_btn[39]);
                hb5.setSpacing(5);
                hb5.setPadding(new Insets(5,45,5,20));

                hb6.getChildren().add(space);
                hb6.setSpacing(5);
                hb6.setPadding(new Insets(5,45,5,20));

                hb7.getChildren().add(info);
                hb7.setSpacing(20);
                hb7.setAlignment(Pos.CENTER);
                hb7.setPadding(new Insets(5,45,5,20));

                hb8.getChildren().add(infoMoney);
                hb8.setSpacing(5);
                hb8.setAlignment(Pos.CENTER);
                hb8.setPadding(new Insets(5,45,5,20));

                //grouping left side of
                // design
                VBox vb1 = new VBox();
                vb1.setAlignment(Pos.TOP_CENTER);
                vb1.setMinSize(430,0);
                vb1.getChildren().addAll(hb1,hb2,hb3,hb4,hb5,hb6,hb7,hb8);

                //event handling to buttons
                all_btn[0].setOnAction(e->setDisplay(all_btn[0],0, showFlight.get(0)));
                all_btn[1].setOnAction(e->setDisplay(all_btn[1],1, showFlight.get(0)));
                all_btn[2].setOnAction(e->setDisplay(all_btn[2],2, showFlight.get(0)));
                all_btn[3].setOnAction(e->setDisplay(all_btn[3],3, showFlight.get(0)));
                all_btn[4].setOnAction(e->setDisplay(all_btn[4],4, showFlight.get(0)));
                all_btn[5].setOnAction(e->setDisplay(all_btn[5],5, showFlight.get(0)));
                all_btn[6].setOnAction(e->setDisplay(all_btn[6],6, showFlight.get(0)));
                all_btn[7].setOnAction(e->setDisplay(all_btn[7],7, showFlight.get(0)));
                all_btn[8].setOnAction(e->setDisplay(all_btn[8],8, showFlight.get(0)));
                all_btn[9].setOnAction(e->setDisplay(all_btn[9],9, showFlight.get(0)));
                all_btn[10].setOnAction(e->setDisplay(all_btn[10],10, showFlight.get(0)));
                all_btn[11].setOnAction(e->setDisplay(all_btn[11],11, showFlight.get(0)));
                all_btn[12].setOnAction(e->setDisplay(all_btn[12],12, showFlight.get(0)));
                all_btn[13].setOnAction(e->setDisplay(all_btn[13],13, showFlight.get(0)));
                all_btn[14].setOnAction(e->setDisplay(all_btn[14],14, showFlight.get(0)));
                all_btn[15].setOnAction(e->setDisplay(all_btn[15],15, showFlight.get(0)));
                all_btn[16].setOnAction(e->setDisplay(all_btn[16],16, showFlight.get(0)));
                all_btn[17].setOnAction(e->setDisplay(all_btn[17],17, showFlight.get(0)));
                all_btn[18].setOnAction(e->setDisplay(all_btn[18],18, showFlight.get(0)));
                all_btn[19].setOnAction(e->setDisplay(all_btn[19],19, showFlight.get(0)));
                all_btn[20].setOnAction(e->setDisplay(all_btn[20],20, showFlight.get(0)));
                all_btn[21].setOnAction(e->setDisplay(all_btn[21],21, showFlight.get(0)));
                all_btn[22].setOnAction(e->setDisplay(all_btn[22],22, showFlight.get(0)));
                all_btn[23].setOnAction(e->setDisplay(all_btn[23],23, showFlight.get(0)));
                all_btn[24].setOnAction(e->setDisplay(all_btn[24],24, showFlight.get(0)));
                all_btn[25].setOnAction(e->setDisplay(all_btn[25],25, showFlight.get(0)));
                all_btn[26].setOnAction(e->setDisplay(all_btn[26],26, showFlight.get(0)));
                all_btn[27].setOnAction(e->setDisplay(all_btn[27],27, showFlight.get(0)));
                all_btn[28].setOnAction(e->setDisplay(all_btn[28],28, showFlight.get(0)));
                all_btn[29].setOnAction(e->setDisplay(all_btn[29],29, showFlight.get(0)));
                all_btn[30].setOnAction(e->setDisplay(all_btn[30],30, showFlight.get(0)));
                all_btn[31].setOnAction(e->setDisplay(all_btn[31],31, showFlight.get(0)));
                all_btn[32].setOnAction(e->setDisplay(all_btn[32],32, showFlight.get(0)));
                all_btn[33].setOnAction(e->setDisplay(all_btn[33],33, showFlight.get(0)));
                all_btn[34].setOnAction(e->setDisplay(all_btn[34],34, showFlight.get(0)));
                all_btn[35].setOnAction(e->setDisplay(all_btn[35],35, showFlight.get(0)));
                all_btn[36].setOnAction(e->setDisplay(all_btn[36],36, showFlight.get(0)));
                all_btn[37].setOnAction(e->setDisplay(all_btn[37],37, showFlight.get(0)));
                all_btn[38].setOnAction(e->setDisplay(all_btn[38],38, showFlight.get(0)));
                all_btn[39].setOnAction(e->setDisplay(all_btn[39],39, showFlight.get(0)));


                // design right side of ticket information
                flightID = new Label("Flight ID");
                flightID.setFont(new Font("Verdana",14));
                flightID.setTextFill(Color.rgb(255,165,0));
                flightID.setPrefSize(70,25);

                time = new Label("Data-Time");
                time.setFont(new Font("Verdana",14));
                time.setTextFill(Color.rgb(255,165,0));
                time.setPrefSize(70,25);

                tickets = new Label("Tickets");
                tickets.setFont(new Font("Verdana",14));
                tickets.setTextFill(Color.rgb(255,165,0));
                tickets.setPrefSize(70,25);

                total = new Label("Total");
                total.setFont(new Font("Verdana",14));
                total.setTextFill(Color.rgb(255,165,0));
                total.setPrefSize(70,25);

                mySeats = new Label("Seats");
                mySeats.setFont(new Font("Verdana",14));
                mySeats.setTextFill(Color.rgb(255,165,0));
                mySeats.setPrefSize(70,25);


                flight_ans = new Label(": " + String.valueOf(showFlight.get(0).getId())); // get info about flight id
                flight_ans.setFont(new Font("Verdana",14));
                flight_ans.setPrefSize(200,25);

                time_ans = new Label(": " + showFlight.get(0).getFlightDate() +" "+ showFlight.get(0).getFlightTime()); // get info about flight time
                time_ans.setFont(new Font("Verdana",14));
                time_ans.setPrefSize(500,25);

                // ticket size
                tickets_ans = new Label(": 0");
                tickets_ans.setFont(new Font("Verdana",14));
                tickets_ans.setPrefSize(200,25);

                // total price
                total_ans = new Label(": $ 0");
                total_ans.setFont(new Font("Verdana",14));
                total_ans.setPrefSize(200,25);

                //seats name or id
                seats_ans = new Label(": ");
                seats_ans.setFont(new Font("Verdana",14));
                seats_ans.setPrefSize(2200,25);

                //customize book now button
                book = new Button("Book now");
                book.setStyle("-fx-background-color: #FFA500");
                book.setTextFill(Color.rgb(255,255,255));
                book.setFont(new Font("Verdana",14));
                book.setPadding(new Insets(8,8,8,8));

                // her ucus icin farkli seat duzeni icin yapilacak
                for(int i=0;i<40;i++){
                    btn_clr[i]=grey;
                }

                // onceden alinan koltuklari belirlemek icin
                for (int c = 0; c < control.get(flightNumber).size()  ; c++) {
                    System.out.println(flightNumber);
                    System.out.println((int) control.get(flightNumber).get(c));
                    all_btn[(int) control.get(flightNumber).get(c)].setStyle("-fx-background-color:#EE4B2B");
                    all_btn[(int) control.get(flightNumber).get(c)].setOnAction(f -> {});

                }


                    //handle event in book now button
                book.setOnAction(e->{

                        for (int i = 0; i < 40; i++) {

                            // get row and  column for seat class
                            int row = (i / 10) + 1;
                            int column = (i % 10) + 1;
                            Seat newSeat = new Seat(row, column, flight.get(0).getPrice());  // we create new seat class
                            Ticket newTicket = new Ticket(flight.get(0), newSeat, (int) flight.get(0).getPrice());
                            u1.getWallet().setTicket(newTicket);



                            // we create new ticket class
                            // thanks to this way ve complate paremeters about wallet

                            // if we have enough money and button is selected we add new ticket in ticket array so we buy ticket
                            if (selected_btn[i] != null && u1.buyingTicket(newTicket)) {


                                // control array daha sonraki satislar icin dolu koltuklari kaydeder
                                control.get(flightNumber).add(i);
                                Login.u1.getMyticket().add(newTicket);




                                selected_btn[i].setStyle("-fx-background-color:#EE4B2B"); // selected button have red color
                                //after sold a seat, remove event handle part corresponding button
                                u1.getWallet().setTicket(newTicket);
                                u1.buyingTicket(newTicket);

                                selected_btn[i].setOnAction(f -> {
                                });
                                info.setText("You have a ticket ");
                                infoMoney.setText("your money amount:   " + u1.getWallet().getMoney());

                                //right side return initial position
                                tickets_ans.setText(": 0");
                                total_ans.setText(": $ 0");
                                seats_ans.setText(": ");
                                seats_val = ": ";
                                count += ticket;
                                ticket = 0;
                                amount = 0;
                            }


                            //if we haven't enough money we give info
                            else if (selected_btn[i] != null && !u1.buyingTicket(newTicket)) {

                                info.setText("You haven't enough money. ");
                                selected_btn[i].setStyle("-fx-background-color:#B2BEB5");
                                btn_clr[i] = grey;

                                //right side return initial position
                                tickets_ans.setText(": 0");
                                total_ans.setText(": $ 0");
                                seats_ans.setText(": ");
                                seats_val = ": ";
                                ticket = 0;
                                amount = 0;
                                infoMoney.setText("your money amount:   " + u1.getWallet().getMoney());

                            }

                        }




                    //when after all seats were booked, disable book now button
                    if(count==all_btn.length){
                        book.setDisable(true);
                    }

                    // thanks to this we don't lose booked seat. it is temporal like memory
                    Button[] temp_btn = new Button[40];
                    selected_btn = temp_btn;


                });




                // design right side of info about booked system
                b_available = new Button();
                b_available.setStyle("-fx-background-color:#B2BEB5");
                b_available.setPrefSize(30,35);

                b_sold = new Button();
                b_sold.setStyle("-fx-background-color:#EE4B2B");
                b_sold.setPrefSize(30,35);

                b_selected = new Button();
                b_selected.setStyle("-fx-background-color:#32CD32");
                b_selected.setPrefSize(30,35);

                available = new Label("Available");
                available.setFont(new Font("Verdana",14));
                available.setAlignment(Pos.CENTER_LEFT);
                available.setPadding(new Insets(7,50,5,3));

                sold = new Label("Sold");
                sold.setFont(new Font("Verdana",14));
                sold.setAlignment(Pos.CENTER_LEFT);
                sold.setPadding(new Insets(7,50,5,3));

                selected = new Label("Selected");
                selected.setFont(new Font("Verdana",14));
                selected.setAlignment(Pos.CENTER_LEFT);
                selected.setPadding(new Insets(7,50,5,3));

                //grouping right hand side in showing screen
                VBox temp1 = new VBox();
                temp1.getChildren().addAll(flightID,time,tickets,total,mySeats);
                temp1.setMinSize(70,0);

                VBox temp2 = new VBox();
                temp2.getChildren().addAll(flight_ans,time_ans,tickets_ans,total_ans,seats_ans);
                temp2.setMinSize(70,0);

                HBox h1 = new HBox();
                h1.getChildren().addAll(temp1,temp2);
                h1.setPadding(new Insets(5,5,5,5));
                h1.setSpacing(10);

                HBox h2 = new HBox();
                h2.getChildren().add(book);
                h2.setPadding(new Insets(20,5,20,5));
                h2.setSpacing(10);

                HBox h3 = new HBox();
                h3.getChildren().addAll(b_available,available);
                h3.setPadding(new Insets(5,5,5,5));
                h3.setSpacing(10);

                HBox h4 = new HBox();
                h4.getChildren().addAll(b_sold,sold);
                h4.setPadding(new Insets(5,5,5,5));
                h4.setSpacing(10);

                HBox h5 = new HBox();
                h5.getChildren().addAll(b_selected,selected);
                h5.setPadding(new Insets(5,5,5,5));
                h5.setSpacing(10);

                //separate left and right side using separator
                Separator s = new Separator();
                s.setOrientation(Orientation.VERTICAL);
                s.setMinSize(20,0);

                VBox vb2 = new VBox();
                vb2.getChildren().addAll(h1,h2,h3,h4,h5);
                vb2.setMaxSize(2500,2500);

                HBox mainHB = new HBox();
                mainHB.getChildren().addAll(vb1,s,vb2);

                VBox mainVB = new VBox();
                mainVB.setAlignment(Pos.TOP_CENTER);
                mainVB.getChildren().addAll(title,mainHB);

                //set scene and show
                Scene sc = new Scene(mainVB,770,610);
                stageSeat.setScene(sc);
                stageSeat.setTitle("Seats Screen");
                stageSeat.setMinHeight(650);
                stageSeat.setMinWidth(800);
                stageSeat.show();


            }
        };
        buyButton.setOnAction(event);




    }

    public static void main(String[] args) {
        launch(args);
    }
}