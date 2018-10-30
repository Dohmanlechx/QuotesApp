package com.dohman.behappy.data;

import com.dohman.behappy.model.Quote;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
