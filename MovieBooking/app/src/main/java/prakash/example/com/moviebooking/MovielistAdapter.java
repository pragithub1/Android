package prakash.example.com.moviebooking;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Prakash on 27-Jul-18.
 */

public class MovielistAdapter extends RecyclerView.Adapter<MovielistAdapter.ViewHolder> {
    Context context;
    List<Item> list;
    int[] images=new int[]{R.drawable.premgheet,R.drawable.avatar, R.drawable.ekdeewanatha,R.drawable.hero, R.drawable.hobbit,R.drawable.hostel,R.drawable.housefull, R.drawable.limitless,R.drawable.raees,R.drawable.spy};
    public MovielistAdapter(Context context,List<Item> list){
        this.context=context;
        this.list =list;
    }
    public MovielistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater in=LayoutInflater.from(context);
        view=in.inflate(R.layout.listview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovielistAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
        holder.movie_name.setText(list.get(position).getMovie_name());
        holder.movie_language.setText(list.get(position).getMovie_language());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView movie_name,movie_language;
        Button book;
        public ViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.iv_movie);
            movie_name=(TextView)itemView.findViewById(R.id.tv_movie_name);
            movie_language=(TextView)itemView.findViewById(R.id.tv_movie_language);
           // book=(Button)itemView.findViewById(R.id.bv_book);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos=getAdapterPosition();
            Intent in=new Intent(view.getContext(),Detail.class);
            in.putExtra("name",list.get(pos).getMovie_name());
            in.putExtra("language",list.get(pos).getMovie_language());
            in.putExtra("date",list.get(pos).getDate());
            in.putExtra("actor",list.get(pos).getActor());
            in.putExtra("price",list.get(pos).getPrice());
            in.putExtra("image",images[pos]);

            view.getContext().startActivity(in);


        }
    }
}
