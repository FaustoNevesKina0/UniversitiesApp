package br.usjt.ads20.appfilmes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.usjt.ads20.appfilmes.model.Universidade;
/**
 * Fausto Neves Kina
 * RA 81820328
 */
public class UniversidadeAdaptador extends BaseAdapter {
    private Universidade[] universidades;
    private Context context;

    public UniversidadeAdaptador(Context context, Universidade[] universidades) {
        this.universidades = universidades;
        this.context = context;
    }

    @Override
    public int getCount() {
        return universidades.length;
    }

    @Override
    public Object getItem(int i) {
        if (i >= 0 && i < universidades.length) {
            return universidades[i];
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.universidade_view, viewGroup, false);

            ImageView avatar = (ImageView) view.findViewById(R.id.avatar);
            TextView nome = (TextView) view.findViewById(R.id.nome_universidade);
            TextView pais = (TextView) view.findViewById(R.id.pais_universidade);
            TextView url = (TextView) view.findViewById(R.id.url_universidade);

            view.setTag(new ViewHolder(avatar, nome, pais, url));
        }

        ViewHolder holder = (ViewHolder) view.getTag();

        holder.getNomeUniversidade().setText(universidades[i].getNome());
        holder.getPaisUniversidade().setText(universidades[i].getCountry());
        holder.getUrlIniversidade().setText(universidades[i].getWebPages());
        holder.getImagemUniversidade().setImageBitmap(Util.criaAvatar(context, universidades[i].getAlphaTwoCode()));
//        holder.getImagemUniversidade().setText(universidades[i].getAlphaTwoCode());

        return view;
    }
}
