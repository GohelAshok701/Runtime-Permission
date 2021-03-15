package com.app.runtimepermission

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.app.runtimepermission.databinding.ActivityMainBinding
import permissions.dispatcher.RuntimePermissions

class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnOpenCamera.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnOpenCamera) {
            showCameraWithPermissionCheck()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == cameraRequest && resultCode == Activity.RESULT_OK) {
            val photo: Bitmap = data?.extras?.get("data") as Bitmap
            binding.ivImage.setImageBitmap(photo)
        }
    }
}