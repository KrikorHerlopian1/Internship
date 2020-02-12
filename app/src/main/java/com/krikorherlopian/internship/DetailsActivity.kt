package com.krikorherlopian.internship

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.krikorherlopian.internship.model.Results
import com.krikorherlopian.internship.model.RowDetailsItem
import kotlinx.android.synthetic.main.activity_main.*


class DetailsActivity : AppCompatActivity() {
    private lateinit var result: Results
    private var list: MutableList<Any> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        swipeContainer.isEnabled = false
        swipeContainer.isRefreshing = false
        result = intent.getSerializableExtra("result") as Results
        when (result.type) {
            "REVIEW_RESULT" -> setupReview()
            "INTERVIEW_RESULT" -> supportActionBar?.title = resources.getString(R.string.interview)
            "SALARY_RESULT" -> setupSalary()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    private fun setupReview() {
        supportActionBar?.title = resources.getString(R.string.review)
        val review = result.review

        if (review.location == "")
            review.location = "N/A"

        val employeeIdItem = RowDetailsItem(
            resources.getString(R.string.employer_id), "" + review.employerId,
            R.drawable.ic_person_24dp
        )
        val employerNameItem = RowDetailsItem(
            resources.getString(R.string.employer_name), "" + review.employerName,
            R.drawable.ic_person_24dp
        )
        val jobTitleItem = RowDetailsItem(
            resources.getString(R.string.job_title), "" + review.jobTitle,
            R.drawable.ic_title_24dp
        )
        val locationItem = RowDetailsItem(
            resources.getString(R.string.location), "" + review.location,
            R.drawable.ic_my_location_24dp
        )
        val reviewDateTimeItem = RowDetailsItem(
            resources.getString(R.string.review_date_time), "" + review.reviewDateTime,
            R.drawable.ic_date_24dp
        )
        val employmentStatusItem = RowDetailsItem(
            resources.getString(R.string.employment_status), "" + review.employmentStatus,
            R.drawable.ic_info_24dp
        )
        val approvalStatusItem = RowDetailsItem(
            resources.getString(R.string.approval_status), "" + review.approvalStatus,
            R.drawable.ic_info_24dp
        )
        val lengthOfEmploymentItem = RowDetailsItem(
            resources.getString(R.string.length_of_employment), "" + review.lengthOfEmployment,
            R.drawable.ic_timeline_24dp
        )
        val adviceItem = RowDetailsItem(
            resources.getString(R.string.advice), "" + review.advice,
            R.drawable.ic_text_24dp
        )
        list.add(employeeIdItem)
        list.add(employerNameItem)
        list.add(jobTitleItem)
        list.add(locationItem)
        list.add(reviewDateTimeItem)
        list.add(employmentStatusItem)
        list.add(approvalStatusItem)

        if (review.lengthOfEmployment != null)
            list.add(lengthOfEmploymentItem)
        if (review.advice != null)
            list.add(adviceItem)


        val adapter = RecyclerViewAdapter(
            list, this@DetailsActivity, null
        )
        recyclerView?.layoutManager = LinearLayoutManager(this@DetailsActivity)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    private fun setupSalary() {
        supportActionBar?.title = resources.getString(R.string.salary)
        val salary = result.salary

        if (salary.location == "")
            salary.location = "N/A"
        val employeeIdItem = RowDetailsItem(
            resources.getString(R.string.employer_id), "" + salary.employerId,
            R.drawable.ic_person_24dp
        )
        val employerNameItem = RowDetailsItem(
            resources.getString(R.string.employer_name), "" + salary.employerName,
            R.drawable.ic_person_24dp
        )
        val jobTitleItem = RowDetailsItem(
            resources.getString(R.string.job_title), "" + salary.jobTitle,
            R.drawable.ic_title_24dp
        )
        val locationItem = RowDetailsItem(
            resources.getString(R.string.location), "" + salary.location,
            R.drawable.ic_my_location_24dp
        )
        val reviewDateTimeItem = RowDetailsItem(
            resources.getString(R.string.review_date_time), "" + salary.reviewDateTime,
            R.drawable.ic_date_24dp
        )
        val employmentStatusItem = RowDetailsItem(
            resources.getString(R.string.employment_status), "" + salary.employmentStatus,
            R.drawable.ic_info_24dp
        )
        val basePayItem = RowDetailsItem(
            resources.getString(R.string.base_pay),
            salary.basePay.symbol + " " + salary.basePay.amount +
                    " " + salary.basePay.currencyCode,
            R.drawable.ic_money_24dp
        )
        val meansBasePayItem  = RowDetailsItem(
            resources.getString(R.string.means_pay),
            salary.meanBasePay.symbol + " " + salary.meanBasePay.amount +
                    " " + salary.meanBasePay.currencyCode,
            R.drawable.ic_money_24dp
        )

        list.add(employeeIdItem)
        list.add(employerNameItem)
        list.add(jobTitleItem)
        list.add(locationItem)
        list.add(reviewDateTimeItem)
        list.add(employmentStatusItem)
        list.add(basePayItem)
        list.add(meansBasePayItem)


        val adapter = RecyclerViewAdapter(
            list, this@DetailsActivity, null
        )
        recyclerView?.layoutManager = LinearLayoutManager(this@DetailsActivity)
        recyclerView?.itemAnimator = DefaultItemAnimator()
        recyclerView?.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}