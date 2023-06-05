package it_school.sumdu.edu.myapp.clients;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import it_school.sumdu.edu.myapp.R;

import java.util.ArrayList;


public class ClientListAdapter extends RecyclerView.Adapter<ClientListAdapter.ClientViewHolder> {
    ArrayList<Client> clientArrayList;

    public ClientListAdapter(ArrayList<Client> clients) {
        this.clientArrayList = clients;
    }

    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_item_list_fragment, parent, false);
        return new ClientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        holder.tvClientName.setText(clientArrayList.get(position).name);
        holder.tvClientLastName.setText(String.format("%s", clientArrayList.get(position).lastName));
        holder.tvClientPhoneNumber.setText(clientArrayList.get(position).phoneNumber);
        holder.tvClientAppointment.setText(String.format("%s", clientArrayList.get(position).appointment));
        holder.tvClientComment.setText(clientArrayList.get(position).comment);
    }

    @Override
    public int getItemCount() {
        return clientArrayList.size();
    }

    static class ClientViewHolder extends RecyclerView.ViewHolder {
        TextView tvClientName;
        TextView tvClientLastName;
        TextView tvClientPhoneNumber;
        TextView tvClientAppointment;
        TextView tvClientComment;

        public ClientViewHolder(@NonNull View itemView) {
            super(itemView);
            findViews();
        }

        private void findViews() {
            tvClientName = itemView.findViewById(R.id.tvClientName);
            tvClientLastName = itemView.findViewById(R.id.tvClientLastName);
            tvClientPhoneNumber = itemView.findViewById(R.id.tvClientPhoneNumber);
            tvClientAppointment = itemView.findViewById(R.id.tvClientAppointment);
            tvClientComment = itemView.findViewById(R.id.tvClientComment);
        }
    }
}
