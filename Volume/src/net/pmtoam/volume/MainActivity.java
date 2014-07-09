package net.pmtoam.volume;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity
{
	public AudioManager audiomanage;
	public SeekBar soundBar;
	private int maxVolume, currentVolume;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final SeekBar soundBar = (SeekBar) findViewById(R.id.seekBar1); // ��������
		audiomanage = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		maxVolume = audiomanage.getStreamMaxVolume(AudioManager.STREAM_MUSIC); // ��ȡϵͳ�������
		soundBar.setMax(maxVolume); // �϶������ֵ��ϵͳ�����ƥ��
		currentVolume = audiomanage.getStreamVolume(AudioManager.STREAM_MUSIC); // ��ȡ��ǰֵ
		soundBar.setProgress(currentVolume);

		soundBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() // ����������
		{
			public void onProgressChanged(SeekBar arg0, int progress,
					boolean fromUser)
			{
				audiomanage.setStreamVolume(AudioManager.STREAM_MUSIC,
						progress, 0);
				currentVolume = audiomanage
						.getStreamVolume(AudioManager.STREAM_MUSIC); // ��ȡ��ǰֵ
				soundBar.setProgress(currentVolume);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{
				// TODO Auto-generated method stub
			}
		});
	}
}