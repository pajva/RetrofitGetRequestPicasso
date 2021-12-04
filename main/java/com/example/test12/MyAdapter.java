package com.example.test12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    MainActivity mainActivity;
    ArrayList<User> users;

    public MyAdapter(MainActivity mainActivity, ArrayList<User> users) {
        this.mainActivity = mainActivity;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup){
        LayoutInflater inflater=LayoutInflater.from(mainActivity);
        View v = inflater.inflate(R.layout.indivi_view, null);

        TextView tv1 = v.findViewById(R.id.tv1);
        TextView tv2 = v.findViewById(R.id.tv2);
        TextView tv3 = v.findViewById(R.id.tv3);
        TextView tv4 = v.findViewById(R.id.tv4);
        TextView tv5 = v.findViewById(R.id.tv5);
        TextView tv6 = v.findViewById(R.id.tv6);
        TextView tv7 = v.findViewById(R.id.tv7);
        TextView tv8 = v.findViewById(R.id.tv8);
        ImageView img1 = v.findViewById(R.id.iview1);

        try{
            Picasso.with(mainActivity.getApplicationContext()).load(users.get(i).getImage()).into(img1);
            tv1.setText("Id : "+users.get(i).getId());
            tv2.setText("Name : "+users.get(i).getName());
            tv3.setText("Username : "+users.get(i).getUsername());
            tv4.setText("Email : "+users.get(i).getEmail());
            tv5.setText("Address : "+"\n"+"1.Street : "+users.get(i).getAddress().getStreet()+"\n"+"2.Suite : "+users.get(i).getAddress().getSuite()+"\n"+"3.City : "+users.get(i).getAddress().getCity()+"\n"+"4.Zipcode : "+users.get(i).getAddress().getZipcode()+"\n"+"5.Location : "+"\n"+"  1.Lattitude : "+users.get(i).getAddress().getLocation().getLattitude()+"\n"+"  2.Longitude : "+users.get(i).getAddress().getLocation().getLongitude());
            tv6.setText("Phone : "+users.get(i).getPhone());
            tv7.setText("Website : "+users.get(i).getWebsite());
            tv8.setText("Company : "+users.get(i).getCompany().getCatchPhrase());
        }catch (Exception e){
            System.out.println(e);
        }


        return v;
    }
}
