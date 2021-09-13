package com.fahemaSultana.uniclubz.fragment.universities.adapter;

import com.fahemaSultana.uniclubz.dataModel.ClubListModel;
import com.fahemaSultana.uniclubz.dataModel.UniversityListModel;

public interface RecyclerViewClickListener {
    void onClick(UniversityListModel model);
    void onClick(ClubListModel model);
}
