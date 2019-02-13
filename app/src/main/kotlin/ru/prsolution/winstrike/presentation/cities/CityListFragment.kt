package ru.prsolution.winstrike.presentation.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fmt_city_list.*
import org.koin.androidx.viewmodel.ext.viewModel
import ru.prsolution.winstrike.R
import ru.prsolution.winstrike.presentation.injectFeature
import ru.prsolution.winstrike.presentation.model.CityItem
import ru.prsolution.winstrike.presentation.utils.pref.PrefUtils
import ru.prsolution.winstrike.viewmodel.CityViewModel
import timber.log.Timber

/**
 * Created by Oleg Sitnikov on 2019-02-12
 */

class CityListFragment : Fragment() {

    private val mVm: CityViewModel by viewModel()

    private val itemClick: (CityItem) -> Unit =
            {
                city ->

                PrefUtils.cityPid = city.id

                Timber.tag("$$$").d("Selected city id: ${PrefUtils.cityPid}")

                val action = CityListFragmentDirections.nextAction(city.id,city.name)
                Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(action)
            }

    private val adapter = CityListAdapter(itemClick)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fmt_city_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        injectFeature()


        city_rv.adapter = adapter

        if (savedInstanceState == null) {
            mVm.fetchCities()
        }


        mVm.cityList.observe(this@CityListFragment, Observer { cities ->

            cities?.let {
                updateCities(it)
            }

        })


    }

    private fun updateCities(resource: List<CityItem>) {
        resource.let {
            adapter.submitList(it)
        }
    }
}