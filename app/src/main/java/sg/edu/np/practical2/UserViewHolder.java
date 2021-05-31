package sg.edu.np.practical2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{

    public TextView name, desc;
    public View view;
    public ImageView image, bigImage;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.txtName);
        desc = itemView.findViewById(R.id.txtDesc);
        image = itemView.findViewById(R.id.img_profile);
        bigImage = itemView.findViewById(R.id.bigImage);
        view = itemView;
    }
}
