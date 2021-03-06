package com.foi.air.studentattendancesystem.adaptersStudent;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foi.air.core.entities.Dolazak;
import com.foi.air.studentattendancesystem.R;

import java.util.List;

public class AttendanceListAdapter extends RecyclerView.Adapter<AttendanceListAdapter.AttendanceViewHolder> {

    private Context mCtx;
    private List<Dolazak> listaDolazaka;

    public AttendanceListAdapter(Context mCtx, List<Dolazak> listaDolazaka) {
        this.mCtx = mCtx;
        this.listaDolazaka = listaDolazaka;
    }

    @NonNull
    @Override
    public AttendanceListAdapter.AttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater =LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_attendance_list_adapter, null);
        AttendanceListAdapter.AttendanceViewHolder holder = new AttendanceListAdapter.AttendanceViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceViewHolder attendanceViewHolder, int i) {
        final Dolazak dolazak = listaDolazaka.get(i);

        attendanceViewHolder.numberOfWeek.setText(toString().valueOf(dolazak.getTjedanNastave())+". tjedan nastave " );
        attendanceViewHolder.attendace.setText(dolazak.isPrisustvo() ? "Prisutan" : "Odsutan");
    }

    @Override
    public int getItemCount() {
        return listaDolazaka.size();
    }

    class AttendanceViewHolder extends RecyclerView.ViewHolder {
        TextView numberOfWeek, attendace;

        public AttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            numberOfWeek = itemView.findViewById(R.id.textViewTjedanNastave);
            attendace = itemView.findViewById(R.id.textViewPrisustvo);

        }
    }
}
