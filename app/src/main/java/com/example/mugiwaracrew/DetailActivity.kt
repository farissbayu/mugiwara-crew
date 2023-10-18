package com.example.mugiwaracrew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mugiwaracrew.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    companion object{
        const val EXTRA_DATA = "EXTRA_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Crew>(EXTRA_DATA)

        val name = data?.name.toString()
        val nickname = data?.nickname.toString()
        val photo = data?.photo.toString()
        val bounty = data?.bounty.toString()
        val description = data?.description.toString()

        Glide.with(binding.ivDetailPhoto)
            .load(photo)
            .into(binding.ivDetailPhoto)

        binding.tvDetailBounty.text = "$bounty Berry"
        binding.tvDetailName.text = "$nickname - $name"
        binding.tvDetailDescription.text = description

        supportActionBar?.hide()
    }
}