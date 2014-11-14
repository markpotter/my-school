package com.noumenonsoftware.myschool;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass. Use the {@link DirectoryFragment#newInstance} factory method to create an instance of this fragment.
 */
public class DirectoryFragment extends Fragment {

  public static final int DIRECTORY_TYPE_FRESHMAN = 0;
  public static final int DIRECTORY_TYPE_SOPHOMORE = 1;
  public static final int DIRECTORY_TYPE_JUNIOR = 2;
  public static final int DIRECTORY_TYPE_SENIOR = 3;
  public static final int DIRECTORY_TYPE_ADMIN = 4;
  public static final int DIRECTORY_TYPE_FACULTY = 5;

  private static final String ARG_DIR_TYPE = "directory_type";
  private int dirType;


  /**
   * Use this factory method to create a new instance of this fragment using the provided parameters.
   *
   * @param dirType the type of directory this fragment lists; freshman, sophomore, junior, senior, administrator, faculty
   * @return A new instance of fragment DirectoryFragment.
   */
  public static DirectoryFragment newInstance(int dirType) {
    DirectoryFragment fragment = new DirectoryFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_DIR_TYPE, dirType);
    fragment.setArguments(args);
    return fragment;
  }

  public DirectoryFragment() {
    // Required empty public constructor
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      dirType = getArguments().getInt(ARG_DIR_TYPE, 4);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_directory, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    TextView tv = (TextView)view.findViewById(R.id.directory_title);
    switch (dirType) {
      case DIRECTORY_TYPE_FRESHMAN:
        tv.setText(R.string.directory_freshman);
        break;
      case DIRECTORY_TYPE_SOPHOMORE:
        tv.setText(R.string.directory_sophomore);
        break;
      case DIRECTORY_TYPE_JUNIOR:
        tv.setText(R.string.directory_junior);
        break;
      case DIRECTORY_TYPE_SENIOR:
        tv.setText(R.string.directory_senior);
        break;
      case DIRECTORY_TYPE_FACULTY:
        tv.setText(R.string.directory_faculty);
        break;
      default:
      case DIRECTORY_TYPE_ADMIN:
        tv.setText(R.string.directory_administrator);
        break;
    }
  }
}
