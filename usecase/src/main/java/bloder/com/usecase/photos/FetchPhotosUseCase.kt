package bloder.com.usecase.photos

import arrow.core.EitherOf
import arrow.core.EitherPartialOf
import arrow.fx.IO
import bloder.com.usecase.UseCase

private typealias Photos = List<String>

interface FetchPhotosUseCase : UseCase<EitherPartialOf<Nothing>, Photos>

fun fetchPhotosUseCase(execute: suspend () -> EitherOf<Nothing, Photos>): FetchPhotosUseCase = object : FetchPhotosUseCase {
    override suspend fun run(): EitherOf<Nothing, Photos> = execute()
}