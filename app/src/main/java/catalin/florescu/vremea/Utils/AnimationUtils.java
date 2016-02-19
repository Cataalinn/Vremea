package catalin.florescu.vremea.Utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * Created by Florescu George Cătălin on 24.10.2015.
 */
public class AnimationUtils {

    public static void createRevealEffect(View view) {
        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;
        int finalRadius = Math.max(view.getWidth(), view.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
        anim.setDuration(800);
        view.setVisibility(View.VISIBLE);

        anim.start();
    }

    public static void hideRevealEffect(final View view) {
        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;
        int initialRadius = view.getWidth();

        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);
        anim.setDuration(800);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });

        anim.start();
    }
}
