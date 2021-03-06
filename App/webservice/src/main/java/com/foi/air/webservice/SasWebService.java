package com.foi.air.webservice;

import com.foi.air.webservice.responses.SasWebServiceResponse;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface SasWebService {
    @GET("aktivnost/dohvati/{uloga}/{idUloge}/{tipAktivnosti}/")
    Call<SasWebServiceResponse> getAktivnostForProfesor (@Path("uloga") String uloga, @Path("idUloge") int idUloge, @Path("tipAktivnosti") String tipAktivnosti);

    @GET("aktivnost/dohvati/{uloga}/{idUloge}/{tipAktivnosti}/")
    Call<SasWebServiceResponse> getAktivnostForStudent (@Path("uloga") String uloga, @Path("idUloge") int idUloge, @Path("tipAktivnosti") String tipAktivnosti);

    @GET("prijava/student/{email}/{lozinka}/")
    Call<SasWebServiceResponse> prijavaStudent(@Path("email") String email, @Path("lozinka") String loznika);

    @GET("prijava/profesor/{email}/{lozinka}/")
    Call<SasWebServiceResponse> prijavaProfesor(@Path("email") String email, @Path("lozinka") String loznika);

    @GET("kolegij/dohvati/{uloga}/{idUloge}/")
    Call<SasWebServiceResponse> getKolegijForProfesor (@Path("uloga") String uloga, @Path("idUloge") int idUloge);

    @GET("dvorane/dohvati/{tipDvorane}/")
    Call<SasWebServiceResponse> getDvorane (@Path("tipDvorane") String tipDvorane);

    @GET("kolegij/svi/{uloga}/{idUloge}/")
    Call<SasWebServiceResponse> getAllCourses (@Path("uloga") String uloga, @Path("idUloge") int idUloge);

    @FormUrlEncoded
    @POST("aktivnost/nova/profesor/")
    Call<SasWebServiceResponse> addAktivnost (@Field("profesor") int idProfesora, @Field ("dozvoljenoIzostanaka") int maxIzostanaka, @Field ("pocetak") String pocetak,
                                            @Field ("kraj") String kraj,@Field ("danIzvodenja") String danIzvodenja, @Field ("dvorana") int idDvorane,
                                            @Field ("kolegij") int idKolegija, @Field ("tipAktivnosti") String tipAktivnosti, @Field ("pocetakUpisa") String pocetakUpisa, @Field ("krajUpisa") String krajUpisa );
    @FormUrlEncoded
    @POST("kolegij/novi/profesor/{idUloge}/")
    Call<SasWebServiceResponse> addCourse (@Path("idUloge") int idProfesora, @Field("naziv") String nazivKolegija, @Field ("semestar") int semestarIzvodjenja, @Field ("studij") String nazivStudija);
    @FormUrlEncoded
    @POST("kolegij/dodaj/profesor/{idUloge}/")
    Call<SasWebServiceResponse> addCourseToProfessor (@Path("idUloge") int profesor, @Field ("kolegij") int idKolegija);
    @FormUrlEncoded
    @POST("kolegij/azuriraj/profesor/{idUloge}/")
    Call<SasWebServiceResponse> azurirajKolegij (@Path("idUloge") int profesor, @Field ("idKolegija") int idKolegija, @Field ("naziv") String naziv, @Field ("semestar") int semestar, @Field ("studij") String studij);

    @GET("aktivnost/dohvatiPoDanu/{uloga}/{idUloge}/{danIzvodenja}/")
    Call<SasWebServiceResponse> getAktivnostForProfesorForDay (@Path("uloga") String uloga, @Path("idUloge") int idUloge, @Path("danIzvodenja") String danIzvodenja);

    @GET("aktivnost/dohvatiPoDanu/{uloga}/{idUloge}/{danIzvodenja}/")
    Call<SasWebServiceResponse> getAktivnostForStudentForDay (@Path("uloga") String uloga, @Path("idUloge") int idUloge, @Path("danIzvodenja") String danIzvodenja);


    @GET("kolegij/dohvati/{uloga}/{idUloge}/")
    Call<SasWebServiceResponse> getKolegijForStudent (@Path("uloga") String uloga, @Path("idUloge") int idUloge);
    @FormUrlEncoded
    @POST("kolegij/dodaj/student/{idUloge}/")
    Call<SasWebServiceResponse> addCourseToStudent (@Path("idUloge") int student, @Field ("kolegij") int idKolegija);

    @GET("labosi/dohvati/{kolegij}/{student}/")
    Call<SasWebServiceResponse> getLabosForKolegij (@Path("kolegij") int kolegij, @Path("student") int student);

    @GET("labosi/upisi/{student}/{aktivnost}/")
    Call<SasWebServiceResponse> upisLabosa (@Path("student") int student, @Path("aktivnost") int aktivnost);

    @GET("labosi/ponisti/{student}/{aktivnost}/")
    Call<SasWebServiceResponse> ponistiOdabirLabosa (@Path("student") int student, @Path("aktivnost") int aktivnost);

    @GET("kolegij/{id}/aktivnost/{id}/dolasci/all/student/{id}")
    Call<SasWebServiceResponse> dohvatiEvidencijuForStudent (@Path("kolegij") int kolegij, @Path("aktivnost") int aktivnost, @Path("student") int student);

    @GET("kolegij/tipoviAktivnosti/{idKolegija}/")
    Call<SasWebServiceResponse> getTipAktivnostiForKolegij (@Path("idKolegija") int idKolegija);
    @GET("kolegij/studenti/{idKolegija}/")
    Call<SasWebServiceResponse> getStudentForKolegij (@Path("idKolegija") int idKolegija);

    @GET("evidencija/dohvati/{uloga}/{idUloge}/{kolegij}/{tipAktivnosti}/")
    Call<SasWebServiceResponse> getIzostankeForStudent (@Path("uloga") String uloga, @Path("idUloge") int idUloge, @Path("kolegij") int kolegij, @Path("tipAktivnosti") int tipAktivnosti);

    @GET("aktivnost/dohvati/{uloga}/{idUloge}/all/")
    Call<SasWebServiceResponse> getAllAktivnostForProfesor (@Path("uloga") String uloga, @Path("idUloge") int idUloge);

    @FormUrlEncoded
    @POST("evidentiraj/generirajLozinku/")
    Call<SasWebServiceResponse> generirajLozinku (@Field("aktivnost") int idAktivnosti, @Field ("tjedanNastave") int tjedanNastave);

    @GET("aktivnost/dohvati/{uloga}/{idUloge}/all/")
    Call<SasWebServiceResponse> getAllAktivnostForStudent (@Path("uloga") String uloga, @Path("idUloge") int idUloge);

    @FormUrlEncoded
    @POST("evidentiraj/zabiljezi/")
    Call<SasWebServiceResponse> zabiljeziPrisustvo (@Field("student") int idStudenta, @Field ("tjedanNastave") int tjedanNastave, @Field("aktivnost") int idAktivnosti);

    @FormUrlEncoded
    @POST("evidentiraj/postaviPrisustvo/")
    Call<SasWebServiceResponse> postaviPrisustvo (@Field("aktivnost") int idAktivnosti, @Field ("tjedanNastave") int tjedanNastave);


}
