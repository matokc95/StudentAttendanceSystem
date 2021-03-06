package com.foi.air.studentattendancesystem.adaptersprofesor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foi.air.core.entities.Aktivnost;
import com.foi.air.studentattendancesystem.R;

import java.util.List;

public class ListOfLecturesAdapter extends RecyclerView.Adapter<ListOfLecturesAdapter.LectureViewHolder>{

    private Context mCtx;
    private List<Aktivnost> lectureList;

    public ListOfLecturesAdapter(Context mCtx, List<Aktivnost> lectureList) {
        this.mCtx = mCtx;
        this.lectureList = lectureList;
    }

    @NonNull
    @Override
    public LectureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.adapter_list_of_lectures, null);
        LectureViewHolder holder = new LectureViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LectureViewHolder lectureViewHolder, int i) {
        final Aktivnost aktivnost = lectureList.get(i);

        lectureViewHolder.title.setText(aktivnost.getKolegij());
        lectureViewHolder.day.setText(aktivnost.getDanIzvodenja());
        lectureViewHolder.time.setText(aktivnost.getPocetak());
        lectureViewHolder.classroom.setText(aktivnost.getDvorana());

    }

    @Override
    public int getItemCount() {
        return lectureList.size();
    }

    class LectureViewHolder extends RecyclerView.ViewHolder {
        TextView title, day, time, classroom;

        public LectureViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textViewTitle);
            day = itemView.findViewById(R.id.textViewDay);
            time = itemView.findViewById(R.id.textViewTime);
            classroom = itemView.findViewById(R.id.textViewClassroom);
        }
    }
}
