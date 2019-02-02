package com.khezu.actividad_exoplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepositorioCanciones {
    private static RepositorioCanciones repository = new RepositorioCanciones();
    private HashMap<String, Cancion> leads = new HashMap<>();

    public static RepositorioCanciones getInstance(){
        return repository;
    }

    private RepositorioCanciones(){
        saveLead(new Cancion(R.drawable.secreto_anuel_aa_ft_karol_g, "Anuel AA and Karol G - Secreto"));
        saveLead(new Cancion(R.drawable.caro, "Bad Bunny - Caro"));
        saveLead(new Cancion(R.drawable.fuerte, "Lola Indigo - Fuerte"));
        saveLead(new Cancion(R.drawable.lush_life, "Zara Larsson - Lush Life"));
        saveLead(new Cancion(R.drawable.meant_to_be, "Bebe Rexha ft Florida George Line - Meant to be"));
        saveLead(new Cancion(R.drawable.pa_llamar_tu_atencion, "C. Tangana, Alizz - Pa llamar tu atencion"));
        saveLead(new Cancion(R.drawable.rise, "Jonas Blue ft Jack & Jack - Rise"));
        saveLead(new Cancion(R.drawable.say_my_name, "David Guetta, Bebe Rexha & J Balvin - Say my name"));
        saveLead(new Cancion(R.drawable.the_way_i_are, "Bebe Rexha ft Lil Wayne - The way I are (Dance with somebody)"));
    }

    private void saveLead(Cancion cancion){
        leads.put(cancion.getmId(), cancion);
    }

    public List<Cancion> getLeads(){
        return new ArrayList<>(leads.values());
    }
}
