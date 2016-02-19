package catalin.florescu.vremea.Utils;

import android.app.Activity;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 */
public class CreateFragment {

    public static void addFragment(Activity activity,
                                   @IdRes int containerViewId,
                                   @NonNull Fragment fragment,
                                   @NonNull String fragmentTag) {
        ((FragmentActivity) activity).getSupportFragmentManager()
                .beginTransaction()
                .add(containerViewId, fragment, fragmentTag)
                .disallowAddToBackStack()
                .commit();
    }

    public static void replaceFragment(Activity activity,
                                       @IdRes int containerViewId,
                                       @NonNull Fragment fragment,
                                       @NonNull String fragmentTag,
                                       @Nullable String backStackStateName) {
        ((FragmentActivity) activity).getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment, fragmentTag)
                .addToBackStack(backStackStateName)
                .commit();
    }

}
