import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpAdapter extends BaseExpandableListAdapter {
 
  private Context myContext;
  public ExpAdapter(Context context) {
   myContext = context;
  }
  @Override
  public Object getChild(int groupPosition, int childPosition) {
   return null;
  }
 
  @Override
  public long getChildId(int groupPosition, int childPosition) {
   return 0;
  }
 
  @Override
  public View getChildView(int groupPosition, int childPosition,
    boolean isLastChild, View convertView, ViewGroup parent) {
    
   if (convertView == null) {
    LayoutInflater inflater =  (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView = inflater.inflate(R.layout.child_row, null);
   }
    
   TextView tvPlayerName = (TextView) convertView.findViewById(R.id.tvPlayerName);
   tvPlayerName.setText(arrChildelements[groupPosition][childPosition]);
    
   return convertView;
  }
 
  @Override
  public int getChildrenCount(int groupPosition) {
   return arrChildelements[groupPosition].length;
  }
 
  @Override
  public Object getGroup(int groupPosition) {
   return null;
  }
 
  @Override
  public int getGroupCount() {
   return arrGroupelements.length;
  }
 
  @Override
  public long getGroupId(int groupPosition) {
   return 0;
  }
 
  @Override
  public View getGroupView(int groupPosition, boolean isExpanded,
    View convertView, ViewGroup parent) {
 
   if (convertView == null) {
    LayoutInflater inflater =  (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView = inflater.inflate(R.layout.group_row, null);
   }
    
   TextView tvGroupName = (TextView) convertView.findViewById(R.id.tvGroupName);
   tvGroupName.setText(arrGroupelements[groupPosition]);
    
   return convertView;
  }
 
  @Override
  public boolean hasStableIds() {
   return false;
  }
 
  @Override
  public boolean isChildSelectable(int groupPosition, int childPosition) {
   return true;
  }
 }