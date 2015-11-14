package Controller;

import Db.PlaceDbContext;
import Model.PlaceModel;
import Model.RuleModel;
import org.kie.api.runtime.StatelessKieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Saint on 11/13/2015.
 */
public class RuleController {
    private List<PlaceModel> lp = new ArrayList<PlaceModel>();
    private StatelessKieSession ks;
    List<String> commands = new ArrayList<String>();

    public RuleController(){
        ks = new RuleModel().getKieSession();
        ks.setGlobal("resultList", lp);
        ks.setGlobal("ks", ks);
        ks.setGlobal("rc", this);
        ks.setGlobal("db", PlaceDbContext.getInstance());
    }

    public List<PlaceModel> getResult(){
        return lp;
    }
    public void addActivity(String s){
        commands.add(s);
    }

    public void addDate(String s){
        commands.add(s);
    }

    public void addType(String s){
        commands.add(s);
    }

    public void exec(){
        ks.execute(commands);
    }
}
