
import android.R;
import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ExpandableListView;

public class Trial_main extends ExpandableListActivity
{
 /**
  * strings for group elements
  */
    static final String arrGroupelements[] = 
    {
   "India",
   "Australia",
   "England",
   "South Africa"
 };
 
    /**
  * strings for child elements
  */
static final String arrChildelements[][] =
 {
   {
  "Sachin Tendulkar",
  "Raina",
  "Dhoni",
  "Yuvi"
   },
   {
  "Ponting",
  "Adam Gilchrist",
  "Michael Clarke"
   },
   {
  "Andrew Strauss",
  "kevin Peterson",
  "Nasser Hussain"
   },
   {
  "Graeme Smith",
  "AB de villiers",
  "Jacques Kallis"
   }
    };
 
 DisplayMetrics metrics;
 int width;
 ExpandableListView expList;
  
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_list_content);
         
        expList = getExpandableListView();
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        width = metrics.widthPixels;
        //this code for adjusting the group indicator into right side of the view
        expList.setIndicatorBounds(width - GetDipsFromPixel(50), width - GetDipsFromPixel(10));
        expList.setAdapter(new ExpAdapter(this));
   
  expList.setOnGroupExpandListener(new OnGroupExpandListener()
  {
   @Override
   public void onGroupExpand(int groupPosition) 
   {
    Log.e("onGroupExpand", "OK");
   }
  });
   
  expList.setOnGroupCollapseListener(new OnGroupCollapseListener()
  {
   @Override
   public void onGroupCollapse(int groupPosition) 
   {
    Log.e("onGroupCollapse", "OK");
   }
  });
   
  expList.setOnChildClickListener(new OnChildClickListener()
  {
   @Override
   public boolean onChildClick(ExpandableListView parent, View v,
     int groupPosition, int childPosition, long id) {
    Log.e("OnChildClickListener", "OK");
    return false;
   }
  });
    }
   
    public int GetDipsFromPixel(float pixels)
    {
     // Get the screen's density scale
     final float scale = getResources().getDisplayMetrics().density;
     // Convert the dps to pixels, based on density scale
     return (int) (pixels * scale + 0.5f);
    }
}