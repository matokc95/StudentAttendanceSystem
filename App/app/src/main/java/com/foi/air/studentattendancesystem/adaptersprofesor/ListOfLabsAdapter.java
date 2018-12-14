package com.foi.air.studentattendancesystem.adaptersprofesor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foi.air.core.entities.Aktivnost;
import com.foi.air.core.entities.Lab;
import com.foi.air.studentattendancesystem.R;

import java.util.List;

public class ListOfLabsAdapter extends RecyclerView.Adapter<ListOfLabsAdapter.LabViewHolder> {

    private Context mCtx;
    private List<Aktivnost> labsList;

    public ListOfLabsAdapter(Context mCtx, List<Aktivnost> labsList) {
        this.mCtx = mCtx;
        this.labsList = labsList;
    }

    @NonNull
    @Override
    public LabViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.adapter_list_of_labs, null);
        LabViewHolder holder = new LabViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LabViewHolder labViewHolder, int i) {
        Aktivnost lab = labsList.get(i);

        labViewHolder.title.setText(lab.getKolegij());
        labViewHolder.day.setText(lab.getDanIzvodenja());
        labViewHolder.time.setText(lab.getPocetak());
        labViewHolder.classroom.setText(lab.getDvorana());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class LabViewHolder extends RecyclerView.ViewHolder {
        TextView title, day, time, classroom;
        public LabViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            day = itemView.findViewById(R.id.textViewDay);
            time = itemView.findViewById(R.id.textViewTime);
            classroom = itemView.findViewById(R.id.textViewClassroom);
        }
    }
}
