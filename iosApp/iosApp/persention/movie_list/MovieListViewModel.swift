//
//  MovieListViewModel.swift
//  iosApp
//
//  Created by Sa7ar Nollily on 11/07/1443 AH.
//  Copyright © 1443 orgName. All rights reserved.
//

import Foundation
import shared
import Combine
import SwiftUI


class MovieListViewModel: ObservableObject{
    
    private let networkModule = NetworkModule()
    private let usecaseModule : UsecaseModule
    private let getMovies: GetMovie
    
    @Published var movieListState = MovieListState()

    
    init(){
        self.usecaseModule = UsecaseModule(movieApiService: self.networkModule.movieApiService)
        self.getMovies = self.usecaseModule.getMovie
        self.getMovie()
    }
    
    
    func getMovie(){
        self.getMovies.execute().collectFlow(
            coroutineScope: nil,
            callback: { dataState in
                switch dataState != nil {
                case dataState?.message != nil:
                    self.movieListState = MovieListState(isLoading: false,
                                                         error: dataState?.message ?? "",
                                                         data: [Movie]())
                    print("error")
                case dataState?.data != nil:
                        self.movieListState = MovieListState(isLoading: false,
                                                             error: "",
                                                             data: dataState?.data as! [Movie])
                    print("data")
                case dataState?.isLoading:
                    self.movieListState = MovieListState(isLoading: dataState?.isLoading ?? false,
                                                         error: "",
                                                         data: [Movie]())
                    print("loading")
                default: return

                }
            })
    }
    

}
