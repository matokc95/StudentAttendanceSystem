package com.foi.air.studentattendancesystem.loaders;

import android.support.v4.os.IResultReceiver;

import com.foi.air.core.SasWsDataLoadedListener;
import com.foi.air.core.entities.Aktivnost;
import com.foi.air.core.entities.Kolegij;
import com.foi.air.core.entities.Profesor;
import com.foi.air.core.entities.Seminar;
import com.foi.air.core.entities.Student;
import com.foi.air.studentattendancesystem.uistudent.LabsBooking;

import com.foi.air.core.entities.TipAktivnosti;

import com.foi.air.webservice.SasWebServiceCaller;
import com.foi.air.webservice.SasWebServiceHandler;

public class SasWsDataLoader {
    private Boolean opSuccessful;
    private SasWsDataLoadedListener sasWsDataLoadedListener;
    private SasWebServiceCaller Ws;

    public SasWsDataLoader() {
        Ws = new SasWebServiceCaller(responseHandler);
    }

    public void prijavaStudent(Student data, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForStudenta(data);
    }
    public void prijavaProfesor(Profesor data, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForProfesor(data);
    }
    public void aktivnostForProfesor(Profesor profesor, Aktivnost aktivnost, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAktivnostiProfesora(profesor,aktivnost);
    }
    public void aktivnostForStudent(Student student, Aktivnost aktivnost, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAktivnostiStudenta(student,aktivnost);
    }
    public void kolegijForProfesor(Profesor profesor, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForKolegijiProfesora(profesor);
    }
    public void kolegijForStudent(Student student, SasWsDataLoadedListener sasWsDataLoadedListener) {
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForKolegijiStudenta(student);
    }
    public void Dvorane(String tipDvorane){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForDvorane(tipDvorane);
    }
    public void dodajAktivnost(int idProfesora, int idKolegija, int maxIzostanaka, String pocetak, String kraj, String danIzvodenja, int idDvorane, String tipAktivnosti){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAddSeminar(idProfesora, idKolegija, maxIzostanaka, pocetak, kraj, danIzvodenja, idDvorane,tipAktivnosti, null, null);
    }
    public void dodajAktivnost(int idProfesora, int idKolegija, int maxIzostanaka, String pocetak, String kraj, String danIzvodenja, int idDvorane, String tipAktivnosti, String pocetakUpisa, String krajUpisa){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAddSeminar(idProfesora, idKolegija, maxIzostanaka, pocetak, kraj, danIzvodenja, idDvorane,tipAktivnosti,pocetakUpisa,krajUpisa);
    }
    public void aktivnostForProfesorForDay(int idProfesora, String day, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAktivnostiProfesoraForDay("Profesor",idProfesora,day);
    }
    public void aktivnostForStudentForDay(int idStudenta, String day, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAktivnostiStudentaForDay("Student",idStudenta,day);
    }
    public void dodajKolegij(int idProfesora, String nazivKolegija, int semestarIzvodjenja, String nazivStudija){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAddCourse(idProfesora, nazivKolegija,semestarIzvodjenja,nazivStudija);
    }
    public void sviKolegiji(int id, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForSviKolegiji(id);
    }
    public void dodajKolegijProfesoru(int idProfesor, int idKolegija){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAddCourseToProfesora(idProfesor, idKolegija);
    }
    public void azurirajKolegij(int idProfesora, int idKolegija, String nazivKolegija, int semestarIzvodjenja, String nazivStudija) {
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAzurirajKolegij(idProfesora, idKolegija, nazivKolegija, semestarIzvodjenja, nazivStudija);
    }
    public void dodajKolegijStudentu(int idStudenta, int idKolegija) {
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAddCourseToStudent(idStudenta, idKolegija);
    }
    public void labosForKolegij(Kolegij kolegij, Student student, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForLabsForKolegij(kolegij, student);
    }
    public void upisLabosa(Student student, Aktivnost aktivnost, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForUpisLabosa(student, aktivnost);
    }
    public void ponistiOdabirLabosa(Student student, Aktivnost aktivnost, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForPonistiOdabirlabosa(student, aktivnost);
    }

    public void evidencijaStudent(Kolegij kolegij, Aktivnost aktivnost, Student student, SasWsDataLoadedListener sasWsDataLoadedListener) {
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForDohvatiEvidencijuStudneta(kolegij, aktivnost, student);
    }
    public void studentiForKolegiji(Kolegij kolegij, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForStudentiKolegij(kolegij.getId());
    }
    public void tipAktivnostiForKolegij(Kolegij kolegij, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForTipAktivnostiKolegij(kolegij.getId());
    }
    public void prisustvoStudenta(int idStudent, int idKolegija, int idTipAktivnosti, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForIzostanciStudenti(idStudent,idKolegija,idTipAktivnosti);
    }
    public void allAktivnostForProfesor(Profesor profesor, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAllAktivnostiProfesora(profesor);
    }
    public void allAktivnostForStudent(Student student, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForAllAktivnostiStudenta(student);
    }
    public void zabiljeziPrisustvo(int student, int tjedanNastave, int idAktivnosti, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForZAbiljeziPrisustvo(student, tjedanNastave, idAktivnosti);
    }
    public void postaviPrisustvo(int idAktivnosti, int tjedanNastave, SasWsDataLoadedListener sasWsDataLoadedListener){
        this.sasWsDataLoadedListener = sasWsDataLoadedListener;
        Ws.CallWsForPostaviPrisustvo(idAktivnosti, tjedanNastave);
    }

        public SasWebServiceHandler responseHandler = new SasWebServiceHandler() {
        @Override
        public void onDataArrived(Object message, String stauts, Object data) {
            sasWsDataLoadedListener.onWsDataLoaded(message, stauts, data);
        }
    };

}
