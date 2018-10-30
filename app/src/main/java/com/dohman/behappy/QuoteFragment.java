package com.dohman.behappy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuoteFragment extends Fragment {
    static int color = 0;

    public QuoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View quoteView = inflater.inflate(R.layout.fragment_quote, container, false);

        TextView quoteText = quoteView.findViewById(R.id.quoteText);
        TextView byAuthor = quoteView.findViewById(R.id.byAuthor);
        CardView cardView = quoteView.findViewById(R.id.cardView);

        String quote = getArguments().getString("quote");
        String author = getArguments().getString("author");

        int colors[] = new int[]{R.color.colorPrimaryDark, R.color.secondary_text,
                R.color.indigo_400, R.color.amber_900, R.color.purple_600, R.color.cyan_900, R.color.red_600, R.color.brown_700, R.color.lime_800};

        quoteText.setText(quote);
        byAuthor.setText("-" + author);

        cardView.setBackgroundResource(getRandomQuote(colors));

        return quoteView;
    }

    public static final QuoteFragment newInstance(String quote, String author) {
        QuoteFragment fragment = new QuoteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("quote", quote);
        bundle.putString("author", author);
        fragment.setArguments(bundle);

        return fragment;
    }

    int getRandomQuote(int[] colorArray) {
        int quotesArrayLength = colorArray.length;
        int randomNum;

        do {
            randomNum = ThreadLocalRandom.current().nextInt(quotesArrayLength);
        } while (colorArray[randomNum] == color);

        color = colorArray[randomNum];

        return color;
    }

}
