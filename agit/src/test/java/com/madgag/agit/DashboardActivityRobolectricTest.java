package com.madgag.agit;

import android.widget.Button;
import com.google.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(InjectedTestRunner.class)
public class DashboardActivityRobolectricTest {

    @Inject DashboardActivity dashboardActivity;

	@Test
	public void shouldBeCool() {
		dashboardActivity.onCreate(null);

        Button injectedTextView = (Button) dashboardActivity.findViewById(R.id.GoCloneButton);
        assertThat(injectedTextView.getText().toString(), equalTo("Clone..."));
	}
}
