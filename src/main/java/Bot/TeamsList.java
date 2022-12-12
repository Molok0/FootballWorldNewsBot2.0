package Bot;

import java.util.HashMap;

public class TeamsList {
     private HashMap<String,String> FootballClubs = new HashMap<String,String>();
     private String  Clubs = "";
     public TeamsList() {
          this.FootballClubs.put("Барселона","barcelona");
          this.FootballClubs.put("Манчестер Юнайтед","mu");
          this.FootballClubs.put("Ливерпуль","liverpool");
          this.FootballClubs.put("Ювентус","juventus");
          this.FootballClubs.put("Челси","chelsea");
          this.FootballClubs.put("Зенит","zenit");
          this.FootballClubs.put("ЦСКА","cska");
          this.FootballClubs.put("Бавария","bayern");
          this.FootballClubs.put("Реал Мадрид","real");
          this.FootballClubs.put("Спартак","spartak");
          this.FootballClubs.put("Боруссия Дортмунд","borussia");
          this.FootballClubs.put("Милан","milan");
          this.FootballClubs.put("Локомотив","lokomotiv");
          this.FootballClubs.put("Арсенал","arsenal");
          this.FootballClubs.put("Манчестер Сити","manchester-city");
          this.FootballClubs.put("ПСЖ","psg");
          this.FootballClubs.put("Атлетико","atletico");
          this.FootballClubs.put("Краснодар","krasnodar");
          this.FootballClubs.put("Тоттенхэм","tottenham");
          this.FootballClubs.put("Динамо Москва","dynamo");
          this.FootballClubs.put("Интер","inter");
          this.FootballClubs.put("Рома","roma");
          this.FootballClubs.put("Ростов","rostov");
          this.FootballClubs.put("Рубин","rubin");
          this.FootballClubs.put("Монако","monaco");
          this.FootballClubs.put("Наполи","napoli");
          this.FootballClubs.put("Анжи","anzhi");
          this.FootballClubs.put("Крылья Советов","krylia-sovetov");
          this.FootballClubs.put("Шахтер","shakhtar");
          this.FootballClubs.put("Валенсия","valencia");
          this.FootballClubs.put("Динамо Киев","dynamo-kiev");
          this.FootballClubs.put("Аталанта","atalanta");
          this.FootballClubs.put("Урал","ural");
          this.FootballClubs.put("Аякс","ajax-fc");
          this.FootballClubs.put("Арсенал Тула","arsenal-tula");
          this.FootballClubs.put("Уфа","ufa");
          this.FootballClubs.put("Севилья","sevilla");
          this.FootballClubs.put("Ахмат","akhmat");
          this.FootballClubs.put("Спартак-2","spartak-2");
          this.FootballClubs.put("Лестер","leicester");
          this.FootballClubs.put("Вильярреал","villarreal");
          this.FootballClubs.put("Спартак мол","spartak-juniors");
          this.FootballClubs.put("Реал Мадрид Кастилья","real-madrid-castilla");
          this.FootballClubs.put("Торпедо","torpedo-moscow");
          this.FootballClubs.put("Лацио","lazio");
          this.FootballClubs.put("Ротор","rotor");
          this.FootballClubs.put("Оренбург","orenburg");
          this.FootballClubs.put("РБ Лейпциг","rb-leipzig");
          this.FootballClubs.put("Эвертон","everton");
     }

     public String getClub(String nameTeam) {
          return FootballClubs.get(nameTeam);
     }
     public Boolean checkTeams(String nameTeam){
          if (FootballClubs.get(nameTeam) == null) return false;
          else return true;
     }

     public String toString(){
         for (String key: FootballClubs.keySet()){
             Clubs = Clubs + key + "\n";
         }
         return Clubs.substring(0,Clubs.length()-1);
     }
}
