package woowacourse.movie.list.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import woowacourse.movie.R
import woowacourse.movie.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity(), HomeActivityContract.View {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)/*ActivityHomeBinding.inflate(layoutInflater)*/
        binding.home = this
        presenter = HomePresenter(this)
        setContentView(binding.root)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            presenter.onBottomNavItemSelected(item.itemId)
            true
        }
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitAllowingStateLoss()
    }
}
