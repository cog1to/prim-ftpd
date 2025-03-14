package org.primftpd.prefs;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Defined in manifest with Theme. Required as it does not work to change theme
 * programmatically for {@link PreferenceActivity}.
 *
 */
public class FtpPrefsActivityThemeLight extends FtpPrefsActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // check theme and launch the other activity if necessary
        Theme theme = LoadPrefsUtil.theme(LoadPrefsUtil.getPrefs(getBaseContext()));
        if (Theme.DARK == theme) {
            this.finish();
            startActivity(new Intent(this, FtpPrefsActivityThemeDark.class));
        } else if (Theme.SYS_DEFAULT == theme) {
            this.finish();
            startActivity(new Intent(this, FtpPrefsActivity.class));
        }
    }
}
