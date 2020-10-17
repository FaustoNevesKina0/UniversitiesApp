package br.usjt.ads20.appfilmes;

import android.widget.ImageView;
import android.widget.TextView;
/**
 * Fausto Neves Kina
 * RA 81820328
 */
public class ViewHolder {
    private ImageView imagemUniversidade;
    private TextView nomeUniversidade;
    private TextView paisUniversidade;
    private TextView urlIniversidade;

    public ViewHolder(ImageView imagemUniversidade, TextView nomeUniversidade, TextView pais, TextView url) {
        this.imagemUniversidade = imagemUniversidade;
        this.nomeUniversidade = nomeUniversidade;
        paisUniversidade = pais;
        urlIniversidade = url;
    }

    public TextView getNomeUniversidade() {
        return nomeUniversidade;
    }

    public void setNomeUniversidade(TextView nomeUniversidade) {
        this.nomeUniversidade = nomeUniversidade;
    }

    public TextView getPaisUniversidade() {
        return paisUniversidade;
    }

    public void setPaisUniversidade(TextView paisUniversidade) {
        this.paisUniversidade = paisUniversidade;
    }

    public ImageView getImagemUniversidade() {
        return imagemUniversidade;
    }

    public void setImagemUniversidade(ImageView imagemUniversidade) {
        this.imagemUniversidade = imagemUniversidade;
    }

    public TextView getUrlIniversidade() {
        return urlIniversidade;
    }

    public void setUrlIniversidade(TextView urlIniversidade) {
        this.urlIniversidade = urlIniversidade;
    }
}
