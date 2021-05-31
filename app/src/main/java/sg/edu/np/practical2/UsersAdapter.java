package sg.edu.np.practical2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {
    Context context;
    ArrayList<User> obj;


    public UsersAdapter(Context c, ArrayList d)
    {
        context = c;
        obj = d;
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = null;

        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user, parent, false);
        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User u = obj.get(position);

        holder.name.setText(u.getName());
        holder.desc.setText(u.getDesc());

        if(u.getName().endsWith("7"))
        {
            holder.bigImage.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.bigImage.setVisibility(View.GONE);
        }

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setMessage(u.getName());
                builder1.setTitle("Profile");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "View",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent goToMainActivity = new Intent(context, MainActivity.class);
                                goToMainActivity.putExtra("id", position);
                                context.startActivity(goToMainActivity);
                            }
                        });
                builder1.setNegativeButton(
                        "Close",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return obj.size();
    }


}
