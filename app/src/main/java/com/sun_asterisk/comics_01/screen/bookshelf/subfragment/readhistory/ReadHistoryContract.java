package com.sun_asterisk.comics_01.screen.bookshelf.subfragment.readhistory;

import com.sun_asterisk.comics_01.data.model.Comic;
import java.util.List;

public interface ReadHistoryContract {
    interface View {
        void onGetReadHistorySuccess(List<Comic> comics);
        void onGetReadHistoryError(Exception exception);
        void onNoDataReadHistoryAvailable();
    }

    interface Presenter {
        void getReadHistory();
    }
}
