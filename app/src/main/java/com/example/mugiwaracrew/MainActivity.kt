package com.example.mugiwaracrew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mugiwaracrew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Crew>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMugiwara.setHasFixedSize(true)

        list.addAll(getListCrews())
        showRecyclerList()
    }

    private fun getListCrews(): ArrayList<Crew> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataBounty = resources.getStringArray(R.array.data_bounty)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataNickname = resources.getStringArray(R.array.data_nickname)
        val listCrew = ArrayList<Crew>()
        for (i in dataName.indices){
            val crew = Crew(dataName[i], dataBounty[i], dataPhoto[i], dataNickname[i], dataDescription[i])
            listCrew.add(crew)
        }
        return listCrew
    }

    private fun showRecyclerList() {
        binding.rvMugiwara.layoutManager = LinearLayoutManager(this)
        val listCrewAdapter = CrewAdapter(list)
        binding.rvMugiwara.adapter = listCrewAdapter

        listCrewAdapter.setOnItemClickCallback(object: CrewAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Crew){
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("EXTRA_DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_about){
            val intent = Intent(this@MainActivity, AboutMeActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }
}