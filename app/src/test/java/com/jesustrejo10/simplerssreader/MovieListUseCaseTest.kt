package com.jesustrejo10.simplerssreader

import com.jesustrejo10.simplerssreader.data.local.datasource.MovieDao
import com.jesustrejo10.simplerssreader.data.local.entities.Movie
import com.jesustrejo10.simplerssreader.data.remote.repository.MoviesRepository
import com.jesustrejo10.simplerssreader.model.data.response.GetMoviesResponse
import com.jesustrejo10.simplerssreader.model.usecases.GetMovieListUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MovieListUseCaseTest {

    lateinit var repo : MoviesRepository
    lateinit var localDataSource : MovieDao
    lateinit var useCaseResult : GetMovieListUseCase

    @Before()
    fun setup(){
        repo = MockRepo()
        localDataSource = MockDao()
        useCaseResult = GetMovieListUseCase(localDataSource,repo)
    }

    @Test
    fun addition_isCorrect() {
        runBlocking<Unit> {
            useCaseResult.invoke(Unit)
        }
    }
}


class MockDao : MovieDao() {

    override fun insert(vararg args: Movie) {
    }

    override fun insert(args: List<Movie>) {
    }

    override fun getMovies(): List<Movie> {
        return emptyList()
    }
}

class MockRepo : MoviesRepository {
    override suspend fun getMovies(): GetMoviesResponse {
        return GetMoviesResponse(emptyList())
    }
}