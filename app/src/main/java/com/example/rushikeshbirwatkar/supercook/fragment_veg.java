package com.example.rushikeshbirwatkar.supercook;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class fragment_veg extends Fragment {

    String imagepath;
    int i;
    String nn;
    TextView textView;
    ImageView imageView;
    GridView gridView;
    String recipestitle;
    String urltoimg;
    String mainrecipes;
    String imgurl;
    String recipesurl;
   // GridView gridView;

    public ArrayList<String> imgnamelist;
    public ArrayList<String> imglist;
    public ArrayList<String> urltorecipes;
    public ArrayList<String> receiptitlearraylist;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_veg, container, false);


        gridView = (GridView) view.findViewById(R.id.gridview);


        new Getfoodrecipes().execute();

        /*Demoviewadapter dmv = new Demoviewadapter();

        gridView.setAdapter(dmv);*/



        return view;

    }

     class Getfoodrecipes extends AsyncTask<Void, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getActivity(), "In Pre Execute", Toast.LENGTH_SHORT).show();
        }


        @Override
        protected Void doInBackground(Void... voids) {
            HttpHandler sh = new HttpHandler();
            //String url = "https://www.food2fork.com/api/search?key=5aab65d0727765e445f2fefc513edde4&q=chicken%20breast&page=2";
            String url="https://www.food2fork.com/api/search?key=3ce4bb108d7dc6deb9b23127acc2fc84&q=veg&page=2";
            String jsonStr = sh.makeServiceCall(url);


            if (jsonStr != null) {

                try {

                    receiptitlearraylist = new ArrayList<String>();

                    imglist = new ArrayList<String>();
                    urltorecipes = new ArrayList<String>();

                   // Toast.makeText(getActivity(), "hii", Toast.LENGTH_SHORT).show();

                    JSONObject jsonObject = new JSONObject(jsonStr);
                    JSONArray recipes = jsonObject.getJSONArray("recipes");


                    for (int i = 0; i < recipes.length(); i++) {

                        JSONObject numberofrecipes = recipes.getJSONObject(i);
                        //  JSONObject number = numberofrecipes.getJSONObject(numberofrecipes.keys().next());
                        recipestitle = numberofrecipes.getString("title");

                        imgurl = numberofrecipes.getString("image_url");
                        recipesurl = numberofrecipes.getString("source_url");


                        imglist.add(imgurl);
                        urltorecipes.add(recipesurl);
                        receiptitlearraylist.add(recipestitle);

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "JSON parsing error", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            } else {
                Toast.makeText(getActivity(), "Couldnt get JSON from server", Toast.LENGTH_SHORT).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


           Demoviewadapter dmv = new Demoviewadapter();
            gridView.setAdapter(dmv);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //Toast.makeText(Main2Activity.this, "HIIIIIIIIIIIIIIIII", Toast.LENGTH_SHORT).show();
                    // imagepath = (String) parent.getItemAtPosition(position);
                    //   urltoimg = imglist.get(position);
                    mainrecipes = urltorecipes.get(position);

                    //Toast.makeText(Main2Activity.this, imagepath, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), Main3Activity.class);
                    //i.putExtra("key", urltoimg);
                    i.putExtra("keyforecipes", mainrecipes);
                    // i.putExtra("keyforposition",position);
                    startActivity(i);

                }
            });
        }
        }

    class Demoviewadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return receiptitlearraylist.size();
        }

        @Override
        public Object getItem(int position) {

            return receiptitlearraylist.get(position);
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {



            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.gridlayout, null);

            imageView = view.findViewById(R.id.img);

            nn = imglist.get(position);
            Glide.with(view).load(nn).into(imageView);

            //imageView.setImageResource(Integer.parseInt(imglist.get(position)));

            textView = view.findViewById(R.id.text);
            textView.setText(receiptitlearraylist.get(position));

            return view;
        }
    }
    }

